import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> tree;
	
	private static class Node implements Comparable<Node> {
		private int vertex;
		private int weight;
		
		private Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
	
	private static int dijkstra(int start, boolean isDiameterRequired) {
		int [] weights = new int [n + 1];
		Arrays.fill(weights, Integer.MAX_VALUE);
		weights[start] = 0;
		
		int maxWeight = Integer.MIN_VALUE, maxVertex = -1;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		minHeap.offer(new Node(start, 0));
		
		while(!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			int src = node.vertex;
			int weight = node.weight;
			
			if(weight > weights[src]) continue;
			
			for(Node nextNode : tree.get(src)) {
				int des = nextNode.vertex;
				int nextWeight = weight + nextNode.weight;
				
				if(nextWeight < weights[des]) {
					weights[des] = nextWeight;
					minHeap.offer(new Node(des, nextWeight));
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(weights[i] > maxWeight) {
				maxWeight = weights[i];
				maxVertex = i;
			}
		}
		
		return isDiameterRequired ? maxWeight : maxVertex;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) tree.add(new ArrayList<>());
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken()),
					weight = Integer.parseInt(st.nextToken());
			
			tree.get(src).add(new Node(des, weight));
			tree.get(des).add(new Node(src, weight));
		}
		
		int diameterPoint = dijkstra(1, false);
		
		System.out.print(dijkstra(diameterPoint, true));
	}
}