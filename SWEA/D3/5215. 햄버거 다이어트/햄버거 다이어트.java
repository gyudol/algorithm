import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
			final int[][] items = new int[N][2];
			int[][] dp = new int[N + 1][L + 1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken());
				items[i][1] = Integer.parseInt(st.nextToken());
			}	
			
			for(int i = 1; i <= N; i++) {
				int itemWeight = items[i - 1][1], itemScore = items[i - 1][0];
				
				for(int w = 1; w <= L; w++) {
					if(itemWeight > w) dp[i][w] = dp[i - 1][w];
					else dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - itemWeight] + itemScore);
				}
			}
			
			result.append('#').append(tc).append(' ').append(dp[N][L]).append('\n');
		}

		System.out.print(result);
	}
}