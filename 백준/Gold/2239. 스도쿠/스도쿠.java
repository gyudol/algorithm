import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	static final int N = 9, CUT = 3;
	static int[][] board = new int[N][N];
	static List<Axis> zeroList = new ArrayList<>();
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static boolean isPromising(int curRow, int curCol, int num) {
		int srcRow = curRow / CUT * CUT, desRow = srcRow + CUT,
				srcCol = curCol / CUT * CUT, desCol = srcCol + CUT;
		
		for (int row = 0; row < N; row++) {
			if (board[row][curCol] == num) return false;
		}
		
		for (int col = 0; col < N; col++) {
			if (board[curRow][col] == num) return false;
		}
		
		for (int row = srcRow; row < desRow; row++) {
			for (int col = srcCol; col < desCol; col++) {
				if (board[row][col] == num) return false;
			}
		}
		
		return true;
	}
	
	static boolean playSudoku(int depth) {
		if (depth == zeroList.size()) return true;
		Axis axis = zeroList.get(depth);
		
		for (int num = 1; num <= N; num++) {
			if (!isPromising(axis.row, axis.col, num)) continue;
			
			board[axis.row][axis.col] = num;
			if (playSudoku(depth + 1)) return true;
			board[axis.row][axis.col] = 0;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		for (int row = 0; row < N; row++) {
			String line = br.readLine();
			
			for (int col = 0; col < N; col++) {
				board[row][col] = line.charAt(col) - '0';
				if (board[row][col] == 0) zeroList.add(new Axis(row, col));
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