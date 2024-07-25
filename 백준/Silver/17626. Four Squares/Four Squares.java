import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int [n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - j * j]);
			dp[i]++;	// 제곱수는 모두 1이므로, minValue + 1
		}
		
		System.out.print(dp[n]);
	}
}