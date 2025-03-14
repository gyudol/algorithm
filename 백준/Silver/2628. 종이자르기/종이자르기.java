import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
	static int W, H;
	static List<Integer> rows, cols;
	
	static int getMaxArea() {
		int rowOffset = 0, colOffset = 0;
		
		Collections.sort(rows);
		Collections.sort(cols);
		
		for (int i = 0; i < rows.size() - 1; i++) 
			rowOffset = Math.max(rows.get(i + 1) - rows.get(i), rowOffset);
		for (int i = 0; i < cols.size() - 1; i++)
			colOffset = Math.max(cols.get(i + 1) - cols.get(i), colOffset);
		
		return rowOffset * colOffset;
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
		
		cols.addAll(Arrays.asList(0, W));
		rows.addAll(Arrays.asList(0, H));
		
		System.out.print(getMaxArea());
	}
}