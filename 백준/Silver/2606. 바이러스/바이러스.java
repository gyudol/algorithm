import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	
	private static int dfs(int src, boolean [][] computers, boolean [] isVisited) {
		if(isVisited[src]) return 0;
		
		isVisited[src] = true;
		int count = 1;
		
		for(int des = 1; des <= n; des++) {
			if(!computers[src][des]) continue;
			
			count += dfs(des, computers, isVisited);
		}
		
		return count;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean [][] computers = new boolean [n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken());
			
			computers[src][des] = computers[des][src] = true;
		}
		
		System.out.print(dfs(1, computers, new boolean [n + 1]) - 1);
	}
}