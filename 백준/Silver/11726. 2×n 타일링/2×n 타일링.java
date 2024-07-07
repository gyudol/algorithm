import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int DIV = 10007;
	private static int [] dp;
	
	private static int fillSquare(int n) {
		if(dp[n] != 0) return dp[n];
		
		return dp[n] = (fillSquare(n - 1) + fillSquare(n - 2)) % DIV;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int [n + 1];
		dp[1] = 1;
		if(n > 1) dp[2] = 2;
		
		for(int i = 3; i < n; i++) fillSquare(i);
		
		System.out.print(fillSquare(n));
	}
}