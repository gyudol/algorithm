import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int MAX = 1667;	// (4995 / 3) + (5 / 5) = 1666
	private static final int [] ENV = {3, 5};
	private static int [] dp;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int [n + 1];
		
		Arrays.fill(dp, MAX);
		dp[0] = 0;
		
		for(int env : ENV) {
			for(int i = env; i <= n; i++) {
				if(i >= env) dp[i] = Math.min(dp[i], dp[i - env] + 1);
			}
		}
	
		System.out.print(dp[n] == MAX ? -1 : dp[n]);
	}
}