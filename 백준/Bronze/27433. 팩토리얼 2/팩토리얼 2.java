import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 20;
	private static long [] dp = new long [MAX + 1];
	
	private static long factorial(int num) {
		if(dp[num] != 0) return dp[num];
		if(num <= 1) return dp[num] = 1;
		
		return dp[num] = num * factorial(num - 1);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(factorial(N));
	}
}