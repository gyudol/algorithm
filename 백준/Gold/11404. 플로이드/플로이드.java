import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final long MAX = 10000000001L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); 
		int m = Integer.parseInt(br.readLine());
		long [][] buses = new long [n + 1][n + 1];
		
		for(long [] costs : buses) Arrays.fill(costs, MAX);
		for(int i = 1; i <= n; i++) buses[i][i] = 0;
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken()),
					cost = Integer.parseInt(st.nextToken());
		
			buses[src][des] = Math.min(buses[src][des], cost);
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					buses[i][j] = Math.min(buses[i][j], buses[i][k] + buses[k][j]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				long cost = buses[i][j];
				
				if(cost >= MAX) result.append(0).append(' ');
				else result.append(cost).append(' ');
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}