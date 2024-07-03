import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int n;
	private static int [][] dp;
	private static int [] stairs;
	
	private static int maxScore(int des, int con) {
		if(des < 0) return 0;
		if(dp[des][con] != -1) return dp[des][con];
		
		return dp[des][con] = stairs[des] + (con == 0 ? 
				Math.max(maxScore(des - 2, 0), maxScore(des - 2, 1))
				: maxScore(des - 1, 0));
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int [n][2];
		stairs = new int [n];
		
		for(int i = 0; i < n; i++) stairs[i] = Integer.parseInt(br.readLine());
		for(int [] row : dp) Arrays.fill(row, -1);
		
		dp[0][0] = stairs[0];	dp[0][1] = 0;		
		
		System.out.print(Math.max(maxScore(n - 1, 0), maxScore(n - 1, 1)));
	}
}