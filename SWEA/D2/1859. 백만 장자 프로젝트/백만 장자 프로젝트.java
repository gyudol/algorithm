import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			long revenue = 0;
			final int[] prices = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int day = 0; day < N; day++) prices[day] = Integer.parseInt(st.nextToken());
			
			int max = prices[N - 1];
			for(int day = N - 2; day >= 0; day--) {
				max = Math.max(prices[day], max);
				revenue += max - prices[day];
			}
			
			result.append('#').append(tc).append(' ').append(revenue).append('\n');
		}
		
		System.out.print(result);
	}
}