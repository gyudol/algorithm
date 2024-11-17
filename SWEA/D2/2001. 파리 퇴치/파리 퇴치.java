import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int getMaxFlies(int N, int M, int[][] flies) {
		int[][] prefixSum = new int[N + 1][N + 1];
		int max = Integer.MIN_VALUE;
		
		for(int row = 1; row <= N; row++) {
			for(int col = 1; col <= N; col++) prefixSum[row][col] = flies[row - 1][col - 1] + prefixSum[row - 1][col] 
						+ prefixSum[row][col - 1] - prefixSum[row - 1][col - 1];
		}
		
		for(int row = M; row <= N; row++) {
			for(int col = M; col <= N; col++) max = Math.max(max, prefixSum[row][col] - prefixSum[row - M][col] 
					- prefixSum[row][col - M] + prefixSum[row - M][col - M]);
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			final int[][] flies = new int[N][N];
			
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) flies[row][col] = Integer.parseInt(st.nextToken());
			}
			
			result.append('#').append(tc).append(' ').append(getMaxFlies(N, M, flies)).append('\n');
		}
		
		System.out.print(result);
	}
}