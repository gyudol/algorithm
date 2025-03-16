class Main {
	static final int[] OPPOSITE = {5, 3, 4, 1, 2, 0};
	static final int M = 6;
	static int N;
	static int[][] dices;
	
	static int getIdx(int depth, int num) {
		for (int i = 0; i < M; i++) {
			if (dices[depth][i] == num) return i;
		}
		
		return -1;	// not found
	}
	
	static int getMaxSide(int bottom, int top) {
		for (int num = 6; num > 0; num--) {
			if (num != bottom && num != top) return num;
		}
		
		return -1;	// not found
	}
	
	static int getMaxLine() {
		int max = 0;
		
		for (int i = 1; i <= M; i++) {
			int sum = 0, prevTop = i;
			
			for (int depth = 0; depth < N; depth++) {
				int bottomIdx = getIdx(depth, prevTop),
						bottom = dices[depth][bottomIdx],
						curTop = dices[depth][OPPOSITE[bottomIdx]];
				
				sum += getMaxSide(bottom, curTop);
				prevTop = curTop;
			}
			
			max = Math.max(sum, max);
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
	
	public static void main(String [] args) throws Exception {
		N = readInt();
		dices = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) dices[i][j] = readInt();
		}
		
		System.out.print(getMaxLine());
	}
}