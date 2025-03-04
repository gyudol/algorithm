class Main {
	static final int N = 4;
	static final int MAX = 100;
	
	static int getArea(boolean[][] isVisited) {
		int sum = 0;
		
		for (int y = 0; y < MAX; y++) {
			for (int x = 0; x < MAX; x++) {
				if (isVisited[y][x]) sum++;
			}
		}
		
		return sum;
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
		boolean[][] isVisited = new boolean[MAX][MAX];
		
		for (int i = 0; i < N; i++) {
			int srcX = readInt(), srcY = readInt(), desX = readInt(), desY = readInt();
		
			for (int y = srcY; y < desY; y++) {
				for (int x = srcX; x < desX; x++) isVisited[y][x] = true;
			}
		}
		
		System.out.print(getArea(isVisited));
	}
}