class Main {
	static final int LENGTH = 1001;
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String [] args) throws Exception {
		final int N = readInt();
		StringBuilder result = new StringBuilder();
		int[][] confetti = new int[LENGTH][LENGTH];
		int[] area = new int[N + 1];
		
		for (int num = 1; num <= N; num++) {
			final int srcCol = readInt(), srcRow = LENGTH - readInt() - 1,
					width = readInt(), height = readInt();
			
			for (int row = srcRow; row > srcRow - height; row--) {
				for (int col = srcCol; col < srcCol + width; col++)
					confetti[row][col] = num;
			}
		}
		
		for (int row = 0; row < LENGTH; row++) {
			for (int col = 0; col < LENGTH; col++) area[confetti[row][col]]++;
		}
		
		for (int num = 1; num <= N; num++) result.append(area[num]).append('\n');
		
		System.out.print(result);
	}
}