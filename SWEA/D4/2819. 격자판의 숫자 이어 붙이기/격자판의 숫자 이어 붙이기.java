import java.util.HashSet;
import java.util.Set;

class Solution {
	static final int N = 4;
	static final int TARGET_DEPTH = 7;
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int[][] board = new int[N][N];
	static Set<String> digits; 
	
	static void dfs(int row, int col, String digit) {
		if (digit.length() == TARGET_DEPTH) {
			digits.add(digit);
			return;
		}
		
		for (int[] d : DIRECTIONS) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			dfs(nr, nc, digit + board[nr][nc]);
		}
	}
	
	static int getCount() {
		digits = new HashSet<>();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				dfs(row, col, "");
			}
		}
		
		return digits.size();
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					board[row][col] = readInt();
				}
			}
			
			result.append('#').append(tc).append(' ')
				.append(getCount()).append('\n');
		}
		
		System.out.print(result);
	}
}