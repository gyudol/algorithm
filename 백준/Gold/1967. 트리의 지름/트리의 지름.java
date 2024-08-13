import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int maxWeight;
	private static int maxVertex;
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
	
	private static void dfs(int src, int sum, boolean [] isVisited) {
		if(isVisited[src]) return;
		isVisited[src] = true;
		
		if(sum > maxWeight) {
			maxWeight = sum;
			maxVertex = src;
		}
		
		for(Node node : tree.get(src)) dfs(node.vertex, sum + node.weight, isVisited);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maxWeight = Integer.MIN_VALUE;
		maxVertex = -1; 
		tree = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) tree.add(new ArrayList<>());
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken()),
					weight = Integer.parseInt(st.nextToken());
			
			tree.get(src).add(new Node(des, weight));
			tree.get(des).add(new Node(src, weight));
		}
		
		dfs(1, 0, new boolean [n + 1]);
		maxWeight = Integer.MIN_VALUE;
		dfs(maxVertex, 0, new boolean [n + 1]);
		
		System.out.print(maxWeight);
	}
}