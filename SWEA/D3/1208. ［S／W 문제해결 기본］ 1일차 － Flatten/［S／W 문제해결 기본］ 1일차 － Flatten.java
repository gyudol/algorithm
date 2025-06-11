class Solution {
	static final int T = 10;
	static final int W = 100;
	
	static int N;
	static int[] boxes;
	
	static int getHeightDiffByFlatten() {
		for (int i = 0; i < N; i++) {
			int max = 0, min = 101, maxIdx = -1, minIdx = -1;
			
			for (int j = 0; j < W; j++) {
				if (boxes[j] > max) {
					max = boxes[j];
					maxIdx = j;
				}
				if (boxes[j] < min) {
					min = boxes[j];
					minIdx = j;
				}
			}
			
			if (max - min <= 1) return max - min;
			boxes[maxIdx]--;
			boxes[minIdx]++;
		}
		
		int max = 0, min = 101;
		
		for (int box : boxes) {
			max = Math.max(box, max);
			min = Math.min(box, min);
		}
		
		return max - min;
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
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			boxes = new int[W];
			
			for (int i = 0; i < W; i++) {
				boxes[i] = readInt();
			}
			
			result.append('#').append(tc).append(' ')
				.append(getHeightDiffByFlatten()).append('\n');
		}
		
		System.out.print(result);
	}
}