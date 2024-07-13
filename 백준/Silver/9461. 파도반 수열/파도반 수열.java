import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 100;
	private static long [] dp;
	
	private static long helixTriangle(int n) {
		if(n <= 0) return 0;
		if(dp[n] != 0) return dp[n];
		
		return dp[n] = helixTriangle(n - 1) + helixTriangle(n - 5);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp = new long [MAX + 1];
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = 2;
		
		for(int i = 5; i <= MAX; i++) helixTriangle(i);
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			result.append(helixTriangle(n)).append('\n');
		}
		
		System.out.print(result);
	}
}