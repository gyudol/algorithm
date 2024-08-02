import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static Node [] nodes;
	private static int farthestNodeNum;
	private static int max;
	
	private static class Node {
		public int num;
		public Node parent;
		public Map<Integer, Integer> edges;
		
		private Node(int num) {
			this.num = num;
			parent = null;
			edges = new HashMap<>();
		}
		
		private Node root() {
			if(parent == null) return this;
			return parent = parent.root();
		}
		
		private boolean isConnected(Node o) {
			return root() == o.root();
		}
		
		private void merge(Node o, int cost) {
			edges.put(o.num, cost);
			
			if(isConnected(o)) return;
			
			o.root().parent = this;
		}
	}
	
	private static void dfs(int src, int sum, boolean [] isVisited) {
		if(isVisited[src]) return;
		isVisited[src] = true;
		
		if(sum > max) {
			max = sum;
			farthestNodeNum = src;
		}
		
		Node node = nodes[src];
		
		for(int nodeNum : node.edges.keySet()) {
			dfs(nodeNum, sum + node.edges.get(nodeNum), isVisited);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		nodes = new Node [v + 1];
		farthestNodeNum = -1;
		max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= v; i++) nodes[i] = new Node(i);
		
		for(int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			
			while(true) {
				int des = Integer.parseInt(st.nextToken());
				
				if(des == -1) break;
				
				nodes[src].merge(nodes[des], Integer.parseInt(st.nextToken()));
			}
		}
		
		// 트리의 특성: 임의의 정점에서 최장 정점을 구하면 항상 가장 긴 edge의 정점 중 하나를 포함한다.
		dfs(1, 0, new boolean [v + 1]);
		max = Integer.MIN_VALUE;
		dfs(farthestNodeNum, 0, new boolean [v + 1]);
		
		System.out.print(max);
	}
}
