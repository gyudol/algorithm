import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int vCnt;
	private static ArrayList<ArrayList<Node>> graph;
	
	private static class Node implements Comparable<Node>{
		private int num;
		private int w;
		
		private Node(int num, int w) {
			this.num = num;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.w, other.w);
		}
	}
	
	private static int [] dijkstra(int start) {
		int [] distances = new int [vCnt + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		minHeap.offer(new Node(start, 0));
		
		while(!minHeap.isEmpty()) {
			Node curNode = minHeap.poll();
			int curVertex = curNode.num;
			int curDist = curNode.w;
			
			if(curDist > distances[curVertex]) continue;
			
			for(Node nextNode : graph.get(curVertex)) {
				int nextVertex = nextNode.num;
				int nextDist = curDist + nextNode.w;
				
				if(nextDist < distances[nextVertex]) {
					distances[nextVertex] = nextDist;
					minHeap.offer(new Node(nextVertex, nextDist));
				}
			}
		}
		
		return distances;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		vCnt = Integer.parseInt(st.nextToken()); 
		int eCnt = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		
		for(int i = 0; i <= vCnt; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < eCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()),
					w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		int [] fromStart = dijkstra(start);
		for(int i = 1; i <= vCnt; i++) {
			if(fromStart[i] == Integer.MAX_VALUE) result.append('I').append('N').append('F').append('\n');
			else result.append(fromStart[i]).append('\n');
		}
		
		System.out.print(result);
	}
}