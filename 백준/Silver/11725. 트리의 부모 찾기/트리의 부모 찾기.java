import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int [] tree;		// element = parent
	private static ArrayList<ArrayList<Integer>> edges;
	
	private static void dfs(int src, boolean [] isVisited) {
		isVisited[src] = true;
		
		for(int des : edges.get(src)) {
			if(isVisited[des]) continue;
			
			tree[des] = src;
			
			dfs(des, isVisited);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		tree = new int [n + 1];
		edges = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) edges.add(new ArrayList<>());
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
			
			edges.get(n1).add(n2);
			edges.get(n2).add(n1);
		}
		
		dfs(1, new boolean [n + 1]);
		for(int i = 2; i <= n; i++) result.append(tree[i]).append('\n');
		
		System.out.print(result);
	}
}