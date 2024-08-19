import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_ROW = 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int [][] stickers = new int [MAX_ROW][n];
			int [][] dp = new int [MAX_ROW][n + 1];
			
			for(int i = 0; i < MAX_ROW; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < n; j++) stickers[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = stickers[0][0];
			dp[1][1] = stickers[1][0];
			
			for(int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + stickers[0][i - 1];
				dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + stickers[1][i - 1];
			}
			
			result.append(Math.max(dp[0][n], dp[1][n])).append('\n');
		}
		
		System.out.print(result);
	}
}