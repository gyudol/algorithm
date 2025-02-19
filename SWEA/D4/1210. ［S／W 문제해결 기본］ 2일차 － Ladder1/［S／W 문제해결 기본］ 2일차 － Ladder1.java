import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static final int T = 10;
	private static final int N = 100;
	private static final int[][] DIR = {{-1, 0}, {0, -1}, {0, 1}};
	
	private static boolean isValid(int[][] board, int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N
				&& board[row][col] != 0;
	}
	
	private static int getDirection(int[][] board, int row, int col, int d) {
		if(d != 0) return d;
		
		for(int idx = 1; idx < DIR.length; idx++) {
			int nextRow = row + DIR[idx][0], nextCol = col + DIR[idx][1];
			
			if(!isValid(board, nextRow, nextCol)) continue;
			return idx;
		}
		
		return 0;
	}
	
	private static int climbLadder(int[][] board, int row, int col) {
		int d = 0;
		
		while(row >= 0) {
			d = getDirection(board, row, col, d);
			
			int nextRow = row + DIR[d][0], nextCol = col + DIR[d][1];
			
			if(!isValid(board, nextRow, nextCol)) {
				nextCol -= DIR[d][1];
				nextRow--;
				d = 0;
			}
			
			row = nextRow;
			col = nextCol;
		}
		
		return col;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int tc = 0;
		
		while(tc < T) {
			tc = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int srcRow = -1, srcCol = -1;
			
			for(int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) {
					board[row][col] = Integer.parseInt(st.nextToken());
					
					if(board[row][col] == 2) {
						srcRow = row;
						srcCol = col;
					}
				}
			}
			
			result.append('#').append(tc).append(' ').append(climbLadder(board, srcRow, srcCol)).append('\n');
		}

		System.out.print(result);
	}
}