class Main {
	static final int LENGTH = 1000;
	static int N;
	static int[] heights;
	
	static int getArea(int pivot) {
		int area = 0;
		
		for (int i = 1, base = 0; i <= pivot; i++) {
			if (heights[base] <= heights[i]) {
				area += (i - base) * heights[base];
				base = i;
			}
		}
		
		for (int i = LENGTH - 1, base = LENGTH; i >= pivot; i--) {
			if (heights[base] <= heights[i]) {
				area += (base - i) * heights[base];
				base = i;
			}
		}
		
		return area + heights[pivot];
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
		heights = new int[LENGTH + 1];
		int maxHeight = 0, pivot = 0;
		
		for (int i = 0; i < N; i++) {
			int L = readInt(), H = readInt();
			
			heights[L] = H;
			if (heights[L] > maxHeight) {
				maxHeight = heights[L];
				pivot = L;
			}
		}
		
		System.out.print(getArea(pivot));
	}
}