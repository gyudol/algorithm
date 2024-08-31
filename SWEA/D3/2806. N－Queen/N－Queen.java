import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static boolean promising(int depth, int col, int[] isVisited) {
		for(int row = 0; row < depth; row++) {
			if(col == isVisited[row] || depth - row == Math.abs(col - isVisited[row])) return false;
		}
		
		return true;
	}
	
	private static int nQueen(int N, int depth, int[] isVisited) {
		if(depth == N) return 1;
		
		int cnt = 0;
		
		for(int col = 0; col < N; col++) {
			if(!promising(depth, col, isVisited)) continue;
			
			isVisited[depth] = col;
			cnt += nQueen(N, depth + 1, isVisited);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			
			result.append('#').append(tc).append(' ').append(nQueen(N, 0, new int[N])).append('\n');
		}
		
		System.out.print(result);
	}
}