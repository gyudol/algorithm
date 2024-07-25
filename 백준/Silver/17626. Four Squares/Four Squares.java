import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int [n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 1; i <= n; i++) {
			if(i % Math.sqrt(i) == 0) dp[i] = 1;
			else {
				int sqrt = (int) Math.sqrt(i);
				int prevPow = (int) Math.pow(sqrt, 2);
				
				while(prevPow > 0) {
					dp[i] = Math.min(dp[i], dp[prevPow] + dp[i - prevPow]);
					prevPow = (int) Math.pow(--sqrt, 2);
				}
			}
		}
		
		System.out.print(dp[n]);
	}
}