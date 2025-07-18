import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}
		
		System.out.print(dp[N]);
	}
}