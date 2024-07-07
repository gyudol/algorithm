import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static boolean [][] edges;
	private static boolean [] isVisited;
	
	private static boolean dfs(int src) {
		if(isVisited[src]) return false;
		isVisited[src] = true;
		
		for(int des = 1; des <= n; des++) {
			if(!edges[src][des]) continue;
			
			dfs(des);
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()), comp = 0;
		edges = new boolean [n + 1][n + 1];
		isVisited = new boolean [n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			edges[u][v] = edges[v][u] = true;
		}
		
		for(int src = 1; src <= n; src++) {
			if(dfs(src)) comp++;
		}
		
		System.out.print(comp);
	}
}