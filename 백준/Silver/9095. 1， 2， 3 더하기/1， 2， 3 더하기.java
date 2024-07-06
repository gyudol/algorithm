import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 10;
	private static int [] dp = new int [MAX + 1];
	
	private static int calculate(int n) {
		if(dp[n] != 0) return dp[n];
		
		// n > 3일 때, 경우의 수 A(n) = 	A(n-1): n-1을 만드는 모든 경우 각각에 1을 더하는 것 +
		//								A(n-2): n-2를 만드는 모든 경우 각각에 2를 더하는 것 +
		//								A(n-3): n-3을 만드는 모든 경우 각각에 3을 더하는 것
		return dp[n] = calculate(n - 1) + calculate(n - 2) + calculate(n - 3);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;	// 1
		dp[2] = 2;	// 1 + 1, 2
		dp[3] = 4;	// 1 + 1 + 1, 1 + 2, 2 + 1, 3
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			result.append(calculate(n)).append('\n');
		}
		
		System.out.print(result);
	}
}