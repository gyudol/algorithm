import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 20;
	private static int [] dp = new int [MAX + 1];
	
	private static int fibonacci(int n) {
		if(dp[n] != 0) return dp[n];
		if(n <= 1) return dp[n] = n;
		
		return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(fibonacci(N));
	}
}