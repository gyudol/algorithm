import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 14;
	private static int [][] dp = new int [MAX + 1][MAX + 1];
	
	private static int resident(int k, int n) {
		if(dp[k][n] != 0) return dp[k][n];
		
		int sum = 0;
		for(int i = 1; i <= n; i++) sum += resident(k - 1, i);
		return dp[k][n] = sum;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= MAX; i++) dp[0][i] = i;
		
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			result.append(resident(k, n)).append('\n');
		}
		
		System.out.print(result);
	}
}