import java.util.ArrayList;
import java.util.List;

class Main {
	static final int N = 9;
	static final int CUT = 3;
	static int[][] board = new int[N][N];
	static int[] rowBit = new int[N];
	static int[] colBit = new int[N];
	static int[] boxBit = new int[N];
	static List<Axis> blankList = new ArrayList<>();
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static boolean isPromising(int row, int col, int num) {
		return ((rowBit[row] | colBit[col] | 
				boxBit[row / CUT * CUT + col / CUT]) & (1 << num)) == 0;
	}
	
	static boolean playSudoku(int depth) {
		if (depth == blankList.size()) return true;
		
		Axis axis = blankList.get(depth);
		int row = axis.row, col = axis.col;
		
		for (int num = 1; num <= N; num++) {
			if (!isPromising(row, col, num)) continue;
			int bit = 1 << num, boxIdx = row / CUT * CUT + col / CUT;
			
			rowBit[row] |= bit;
			colBit[col] |= bit;
			boxBit[boxIdx] |= bit;
			board[row][col] = num;
			
			if (playSudoku(depth + 1)) return true;
			
			rowBit[row] ^= bit;
			colBit[col] ^= bit;
			boxBit[boxIdx] ^= bit;
		}
		
		return false;
	}
	
	static int readInt() throws Exception {
		int c = System.in.read();
		
		while (c <= 32) c = System.in.read();
		return c & 15;
	}
	
	public static void main(String [] args) throws Exception {
		StringBuilder result = new StringBuilder();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				board[row][col] = readInt();
				
				if (board[row][col] == 0) blankList.add(new Axis(row, col));
				else {
					int bit = 1 << board[row][col];
					
					rowBit[row] |= bit;
					colBit[col] |= bit;
					boxBit[row / CUT * CUT + col / CUT] |= bit;
				}
			}
		}
		
		playSudoku(0);
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) result.append(board[row][col]);
			result.append('\n');
		}
		
		System.out.print(result);
	}
}