import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static List<Integer> dfsRoute;
	private static List<Integer> bfsRoute;
	
	private static void dfs(int src, boolean [][] edges, boolean [] isVisited) {
		if(isVisited[src]) return;
		isVisited[src] = true;
		dfsRoute.add(src);
		
		for(int des = 1; des <= n; des++) {
			if(!edges[src][des]) continue;
			
			dfs(des, edges, isVisited);
		}
	}
	
	private static void bfs(int v, boolean [][] edges, boolean [] isVisited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		isVisited[v] = true;
		bfsRoute.add(v);
		
		while(!q.isEmpty()) {
			int src = q.poll();
			
			for(int des = 1; des <= n; des++) {
				if(!edges[src][des] || isVisited[des]) continue;
				
				isVisited[des] = true;
				bfsRoute.add(des);
				q.offer(des);
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
		boolean [][] edges = new boolean [n + 1][n + 1];
		dfsRoute = new ArrayList<>();
		bfsRoute = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
			
			edges[v1][v2] = edges[v2][v1] = true;
		}
		
		dfs(v, edges, new boolean [n + 1]);
		bfs(v, edges, new boolean [n + 1]);
		
		for(int vertex : dfsRoute) result.append(vertex).append(' ');
		result.append('\n');
		for(int vertex : bfsRoute) result.append(vertex).append(' ');
		
		System.out.print(result);
	}
}