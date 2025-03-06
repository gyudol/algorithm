import java.util.ArrayList;
import java.util.List;

class Main {
	static final int N = 9;
	static final int CUT = 3;
	static int[][] board = new int[N][N];
	static List<Axis> blankList = new ArrayList<>();
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static boolean isPromising(int curRow, int curCol, int num) {
		int srcRow = curRow / CUT * CUT, srcCol = curCol / CUT * CUT;
		
		for (int i = 0; i < N; i++) {
			if (board[i][curCol] == num) return false;
			if (board[curRow][i] == num) return false;
			if (board[srcRow + i / CUT][srcCol + i % CUT] == num) return false;
		}
		
		return true;
	}
	
	static boolean sudoku(int depth) {
		if (depth == blankList.size()) return true;
		Axis axis = blankList.get(depth);
		
		for (int num = 1; num <= N; num++) {
			if(!isPromising(axis.row, axis.col, num)) continue;
			
			board[axis.row][axis.col] = num;
			if(sudoku(depth + 1)) return true;
			board[axis.row][axis.col] = 0;
		}
		
		return false;
	}
	
	static int readInt() throws Exception {
		int c = System.in.read();
		
		while (c <= 32) c = System.in.read();
		return c & 15;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder result = new StringBuilder();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				board[row][col] = readInt();
				if (board[row][col] == 0) blankList.add(new Axis(row, col));
			}
		}
		
		sudoku(0);
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) result.append(board[row][col]);
			result.append('\n');
		}
		
		System.out.print(result);
	}
}