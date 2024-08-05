import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	
	private static class Node implements Comparable<Node> {
		public int vertex;
		public int time;
		
		private Node(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.time, other.time);
		}
	}
	
	private static int [] dijkstra(ArrayList<ArrayList<Node>> graph, int src) {
		int [] costs = new int [n + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[src] = 0;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		minHeap.offer(new Node(src, 0));
		
		while(!minHeap.isEmpty()) {
			Node curNode = minHeap.poll();
			int curVertex = curNode.vertex;
			int curTime = curNode.time;
			
			if(curTime > costs[curVertex]) continue;
			
			for(Node nextNode : graph.get(curVertex)) {
				int des = nextNode.vertex;
				int nextTime = curTime + nextNode.time;
				
				if(nextTime < costs[des]) {
					costs[des] = nextTime;
					minHeap.offer(new Node(des, nextTime));
				}
			}
		}
		
		return costs;
	}
	
	private static int longestTime(int [] costFromX, int [] costToX) {
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n; i++) max = Math.max(max, costFromX[i] + costToX[i]);
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			reverseGraph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph.get(src).add(new Node(des, time));
			reverseGraph.get(des).add(new Node(src, time));
		}
		
		// X에서 모든 노드까지의 거리와 모든 노드에서 X까지의 거리 계산
		int [] costFromX = dijkstra(graph, x);
		int [] costToX = dijkstra(reverseGraph, x);
		
		System.out.print(longestTime(costFromX, costToX));
	}
}