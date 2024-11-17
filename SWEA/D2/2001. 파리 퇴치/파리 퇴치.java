import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int getMaxFlies(int N, int M, int[][] flies) {
		int srcRow = 0, srcCol = 0, desRow = M - 1, desCol = M - 1;
		int max = Integer.MIN_VALUE;
		
		while(desRow < N) {
			int sum = 0;
			
			for(int row = srcRow; row <= desRow; row++) {
				for(int col = srcCol; col <= desCol; col++) sum += flies[row][col];
			}
			
			max = Math.max(sum, max);
			srcCol++;	desCol++;
			if(desCol >= N) {
				srcRow++;	desRow++;
				srcCol = 0;	desCol = M - 1;
			}
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