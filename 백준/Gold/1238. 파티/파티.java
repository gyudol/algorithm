import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int [][] graph;
	
	private static class Node implements Comparable<Node> {
		public int vertex;
		public int dist;
		
		private Node(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
	}
	
	private static int [] dijkstra(int src) {
		int [] distances = new int [n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[src] = 0;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		minHeap.offer(new Node(src, 0));
		
		while(!minHeap.isEmpty()) {
			Node curNode = minHeap.poll();
			int curVertex = curNode.vertex;
			int curDist = curNode.dist;
			
			if(curDist > distances[curVertex]) continue;
			
			for(int des = 1; des <= n; des++) {
				if(graph[curVertex][des] == 0) continue;
				
				int nextDist = curDist + graph[curVertex][des];
				
				if(nextDist < distances[des]) {
					distances[des] = nextDist;
					minHeap.offer(new Node(des, nextDist));
				}
			}
		}
		
		return distances;
	}
	
	private static int longestTime(int [][] allDistances, int x) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n; i++) {
			int time = allDistances[i][x] + allDistances[x][i];
			
			if(time > max) max = time;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
		graph = new int [n + 1][n + 1];
		int [][] allDistances = new int [n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
					= Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) allDistances[i] = dijkstra(i);
		
		System.out.print(longestTime(allDistances, x));
	}
}
