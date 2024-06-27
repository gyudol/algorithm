import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int TARGET = 1;
	private static int [] dp;
	
	private static int calculate(int N) {
		if(N <= TARGET) return 0;
		if(dp[N] != 0) return dp[N];
		
		dp[N] = calculate(N - 1) + 1;
		
		for(int i = 3; i >= 2; i--) {
			if(N % i == 0) dp[N] = Math.min(dp[N], calculate(N / i) + 1);
		}
		
		return dp[N];
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int [N + 1];
		
		for(int i = 2; i <= N; i++) calculate(i);	// depth가 너무 깊어지면 비효율적이므로 dp를 미리 심어줌
		System.out.print(calculate(N));
	}
}