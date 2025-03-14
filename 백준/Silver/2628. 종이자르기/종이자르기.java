import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
	static int W, H;
	static List<Integer> rows, cols;
	
	static int getMaxArea() {
		int max = 0, srcRow = 0;
		
		Collections.sort(rows);
		Collections.sort(cols);
		
		for (int curRow : rows) {
			int srcCol = 0;
			
			for (int curCol : cols) {
				max = Math.max((curCol - srcCol) * (curRow - srcRow), max);
				srcCol = curCol;
			}
			
			srcRow = curRow;
		}
		
		return max;
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
		W = readInt(); H = readInt();
		final int M = readInt();
		rows = new ArrayList<>();
		cols = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			boolean isVertical = readInt() == 1;
			
			if (isVertical) cols.add(readInt());
			else rows.add(readInt());
		}
		
		cols.add(W);
		rows.add(H);
		
		System.out.print(getMaxArea());
	}
}