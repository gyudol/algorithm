import java.util.ArrayList;
import java.util.List;

class Main {
	static final int N = 10;
	static final int M = 5;
	
	static int[] papers;
	static boolean[][] board;
	static List<Mark> marks;
	static int min;
	
	static boolean isValid(int srcRow, int srcCol, int offset) {
		if (srcRow + offset > N || srcCol + offset > N) return false;
		
		for (int row = srcRow; row < srcRow + offset; row++) {
			for (int col = srcCol; col < srcCol + offset; col++) {
				if (!board[row][col]) return false;
			}
		}
		
		return true;
	}
	
	static void markVisited(int srcRow, int srcCol, int offset, boolean visitState) {
		for (int row = srcRow; row < srcRow + offset; row++) {
			for (int col = srcCol; col < srcCol + offset; col++) {
				board[row][col] = !visitState;
			}
		}
		
		if (visitState) papers[offset]--;
		else papers[offset]++;
	}
	
	static void backtracking(int idx, int cnt) {
		if (idx == marks.size()) min = Math.min(cnt, min);
		if (cnt >= min) return;
		
		Mark mark = marks.get(idx);
		int row = mark.row, col = mark.col;
		
		if (!board[row][col]) {
			backtracking(idx + 1, cnt);
			return;
		}
		
		for (int size = M; size > 0; size--) {
			if (papers[size] == 0 || !isValid(row, col, size)) continue;
			
			markVisited(row, col, size, true);
			backtracking(idx + 1, cnt + 1);
			markVisited(row, col, size, false);
		}
	}
	
	static int getMinimumPaperCount() {
		min = M * M + 1;
		backtracking(0, 0);
		
		return min == M * M + 1 ? -1 : min;
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
		papers = new int[] {0, M, M, M, M, M};
		board = new boolean[N][N];
		marks = new ArrayList<>();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[row][col] = readInt() == 1) {
					marks.add(new Mark(row, col));
				}
			}
		}
		
		System.out.print(getMinimumPaperCount());
	}
	
	static class Mark {
		int row, col;
		
		Mark(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}