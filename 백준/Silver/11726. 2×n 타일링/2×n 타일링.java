import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}
		
		System.out.print(dp[N]);
	}
}