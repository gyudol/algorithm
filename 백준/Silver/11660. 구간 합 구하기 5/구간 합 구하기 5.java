import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] arr;
	private static int[][] dp;
	
	private static int prefixSum(int srcX, int srcY, int desX, int desY) {
		return dp[desX][desY] - dp[desX][srcY - 1] - (dp[srcX - 1][desY] - dp[srcX - 1][srcY - 1]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		dp = new int[n + 1][n + 1];
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) 
				dp[i][j] = arr[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int srcX = Integer.parseInt(st.nextToken()), srcY = Integer.parseInt(st.nextToken());
			int desX = Integer.parseInt(st.nextToken()), desY = Integer.parseInt(st.nextToken());
		
			result.append(prefixSum(srcX, srcY, desX, desY)).append('\n');
		}
		
		System.out.print(result);
	}
}