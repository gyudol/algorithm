import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[][] items = new int[n][];
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			items[i] = new int[] {w, v};
		}
		
		for(int i = 1; i <= n; i++) {
			int itemWeight = items[i - 1][0], itemValue = items[i - 1][1];
			
			for(int w = 1; w <= k; w++) {
				if(itemWeight > w) dp[i][w] = dp[i - 1][w];
				else dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - itemWeight] + itemValue);
			}
		}
		
		System.out.print(dp[n][k]);
	}
}