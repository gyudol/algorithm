import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> graph;
	
	private static class Node implements Comparable<Node>{
		private int vertex;
		private int dist;
		
		private Node(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
	}
	
	private static int dijkstra(int src, int des) {
		int [] distances = new int [n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[src] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(src, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curVertex = curNode.vertex;
			int curDist = curNode.dist;
			
			if(curDist > distances[curVertex]) continue;
			
			for(Node nextNode : graph.get(curVertex)) {
				if(nextNode.dist == 0) continue;
				
				int nextVertex = nextNode.vertex;
				int nextDist = curDist + nextNode.dist;
				
				if(nextDist < distances[nextVertex]) {
					distances[nextVertex] = nextDist;
					pq.offer(new Node(nextVertex, nextDist));
				}
			}
		}
		
		return distances[des];
	}
	
	private static int containRoute(int v1, int v2) {
		int sumV1ToV2 = 0;
		int startToV1 = dijkstra(1, v1);
		int v1ToV2 = dijkstra(v1, v2);
		int v2ToEnd = dijkstra(v2, n);
		
		if(startToV1 == Integer.MAX_VALUE || v1ToV2 == Integer.MAX_VALUE 
				|| v2ToEnd == Integer.MAX_VALUE) sumV1ToV2 = Integer.MAX_VALUE;
		else sumV1ToV2 = startToV1 + v1ToV2 + v2ToEnd;
		
		int sumV2ToV1 = 0;
		int startToV2 = dijkstra(1, v2);
		int v2ToV1 = dijkstra(v2, v1);
		int v1ToEnd = dijkstra(v1, n);
		
		if(startToV2 == Integer.MAX_VALUE || v2ToV1 == Integer.MAX_VALUE 
				|| v1ToEnd == Integer.MAX_VALUE) sumV2ToV1 = Integer.MAX_VALUE;
		else sumV2ToV1 = startToV2 + v2ToV1 + v1ToEnd;
		
		return sumV1ToV2 == Integer.MAX_VALUE && sumV2ToV1 == Integer.MAX_VALUE 
				? -1 : Math.min(sumV1ToV2, sumV2ToV1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		int e = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.get(src).add(new Node(des, dist));
			graph.get(des).add(new Node(src, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
		
		System.out.print(containRoute(v1, v2));
	}
}