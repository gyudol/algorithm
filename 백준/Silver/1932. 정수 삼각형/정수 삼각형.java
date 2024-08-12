import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int [][] dp;
	private static int [][] triangle;
	
	private static int max(int row, int col) {
		if(dp[row][col] != 0) return dp[row][col];
		if(row == n - 1) return dp[row][col] = triangle[row][col];
		
		return dp[row][col] = Math.max(dp[row + 1][col], dp[row + 1][col + 1])
				+ triangle[row][col];
	}	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int [n][n];
		triangle = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j <= i; j++) triangle[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int row = n - 1; row >= 0; row--) {
			for(int col = 0; col <= row; col++) max(row, col);
		}
		
		System.out.print(dp[0][0]);
	}
}