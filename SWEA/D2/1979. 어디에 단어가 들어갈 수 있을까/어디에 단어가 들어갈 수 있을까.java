import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int countPuzzle(int N, int K, int[][] puzzle) {
		int cnt = 0;
		
		for(int row = 0; row < N; row++) {	// horizontal
			int depth = 0;
			
			for(int col = 0; col < N; col++) {
				if(puzzle[row][col] == 1) depth++;
				if(puzzle[row][col] == 0 || col == N - 1) {
					if(depth == K) cnt++;
					depth = 0;
				}
			}
		}
		
		for(int col = 0; col < N; col++) {	// vertical
			int depth = 0;
			
			for(int row = 0; row < N; row++) {
				if(puzzle[row][col] == 1) depth++;
				if(puzzle[row][col] == 0 || row == N - 1) {
					if(depth == K) cnt++;
					depth = 0;
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			final int[][] puzzle = new int[N][N];
			
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) puzzle[row][col] = Integer.parseInt(st.nextToken());
			}
			
			result.append('#').append(tc).append(' ').append(countPuzzle(N, K, puzzle)).append('\n');
		}
		
		System.out.print(result);
	}
}