import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 40;
	private static int [][] dp = new int [MAX + 1][2];
	
	private static int fibonacci(int n, int cntNum) {
		if(dp[n][cntNum] != 0) return dp[n][cntNum];
		if(n <= 1) {
			if(n == 0) return dp[n][cntNum] = Math.abs(cntNum - 1);		// dp[0][1] = dp[1][0] = 0;
			return dp[n][cntNum] = cntNum;								// dp[0][0] = dp[1][1] = 1;
		}
		
		return dp[n][cntNum] = fibonacci(n - 1, cntNum) + fibonacci(n - 2, cntNum);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int cntZero = fibonacci(n, 0);
			int cntOne = fibonacci(n, 1);
			
			result.append(cntZero).append(' ').append(cntOne).append('\n');
		}
		
		System.out.print(result);
	}
}