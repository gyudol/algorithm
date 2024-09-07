import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int order;
	private static int[] isVisited;
	private static ArrayList<ArrayList<Integer>> edges;
	
	private static void dfs(int src) {
		if(isVisited[src] != 0) return;
		isVisited[src] = ++order;
		
		for(int des : edges.get(src)) dfs(des);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		order = 0;
		isVisited = new int[n + 1];
		edges = new ArrayList<>();
		int m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n; i++) edges.add(new ArrayList<>());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			edges.get(u).add(v);
			edges.get(v).add(u);
		}
		
		for(ArrayList<Integer> desList : edges) Collections.sort(desList);
		
		dfs(r);
		for(int i = 1; i <= n; i++) result.append(isVisited[i]).append('\n');
		
		System.out.print(result);
	}
}