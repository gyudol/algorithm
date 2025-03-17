import java.util.Arrays;

class Main {
	static int N;
	static Square[] squares;
	
	static class Square {
		int L, H;
		
		Square(int L, int H) {
			this.L = L;
			this.H = H;
		}
	}
	
	static int getPivotIdx() {
		int pivotIdx = 0;
		
		for (int idx = 0; idx < N; idx++) {
			if (squares[pivotIdx].H < squares[idx].H) pivotIdx = idx;
		}
		
		return pivotIdx;
	}
	
	static int getArea(int pivotIdx) {
		int area = 0;
		
		for (int i = 1, baseIdx = 0; i <= pivotIdx; i++) {
			if (squares[baseIdx].H <= squares[i].H) {
				area += (squares[i].L - squares[baseIdx].L) * squares[baseIdx].H;
				baseIdx = i;
			}
		}
		
		for (int i = N - 2, baseIdx = N - 1; i >= pivotIdx; i--) {
			if (squares[baseIdx].H <= squares[i].H) {
				area += (squares[baseIdx].L - squares[i].L) * squares[baseIdx].H;
				baseIdx = i;
			}
		}
		
		return area + squares[pivotIdx].H;
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
		N = readInt();
		squares = new Square[N];
		
		for (int i = 0; i < N; i++)
			squares[i] = new Square(readInt(), readInt());
		
		Arrays.sort(squares, (s1, s2) -> Integer.compare(s1.L, s2.L));
		
		System.out.print(getArea(getPivotIdx()));
	}
}