import java.util.Arrays;

class Solution {
	static int D, W, K;
	static int[] A, B;
	static int[][] film;
	
	static boolean isValid() {
		if(K == 1) return true;
		
		for (int col = 0; col < W; col++) {
			int cnt = 1;
			
			for (int row = 1; row < D; row++) {
				if (film[row][col] == film[row - 1][col]) {
					if(++cnt == K) break;
				}
				else cnt = 1;

				if (row == D - 1) return false;
			}
		}
		
		return true;
	}
	
	static boolean comb(int depth, int src, int target) {
		if (depth == target) {
			if (isValid()) return true;
			return false;
		}
		
		for (int i = src; i < D; i++) {
			int[] tmp = film[i];
			
			film[i] = A;
			if (comb(depth + 1, i + 1, target)) return true;
			film[i] = B;
			if (comb(depth + 1, i + 1, target)) return true;
			film[i] = tmp;
		}
		
		return false;
	}
	
	static int performTest() {
		for (int i = 0; i < K; i++) {
			if (comb(0, 0, i)) return i;
		}
		
		return K;
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
		StringBuilder result = new StringBuilder();
		final int T = readInt();
		
		for (int tc = 1; tc <= T; tc++) {
			D = readInt();	W = readInt();	K = readInt();
			film = new int[D][W];
			A = new int[W];	B = new int[W];
			Arrays.fill(B, 1);
			
			for (int row = 0; row < D; row++) {
				for (int col = 0; col < W; col++) film[row][col] = readInt();
			}
			
			result.append('#').append(tc).append(' ').append(performTest()).append('\n');
		}

		System.out.print(result);
	}
}