import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static Node [] tree;
	private static boolean [] isVisited;
	
	private static class Node {
		private int parent;
		private List<Integer> children;
		
		private Node() {
			this.parent = -1;
			children = new ArrayList<>();
		}
	}
	
	private static void removeEdge(int vertex) {
		int parent = tree[vertex].parent;
		isVisited[vertex] = true;
		
		if(parent == -1) return;
		
		tree[parent].children.remove(Integer.valueOf(vertex));
		tree[vertex].parent = -1;
	}
	
	private static int dfs(int src) {
		int leaves = 0;
		
		if(isVisited[src]) return leaves;
		isVisited[src] = true;
		
		if(tree[src].children.size() == 0) return 1;
		
		for(int child : tree[src].children) leaves += dfs(child);
		
		return leaves;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), root = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new Node [n];
		isVisited = new boolean [n];
		
		for(int i = 0; i < n; i++) tree[i] = new Node();
		for(int child = 0; child < n; child++) {
			int parent = Integer.parseInt(st.nextToken());
			tree[child].parent = parent;
			
			if(parent == -1) {
				root = child;
				continue;
			}
			
			tree[parent].children.add(child);
		}
		
		int vertex = Integer.parseInt(br.readLine());
		removeEdge(vertex);
		
		System.out.print(dfs(root));
	}
}