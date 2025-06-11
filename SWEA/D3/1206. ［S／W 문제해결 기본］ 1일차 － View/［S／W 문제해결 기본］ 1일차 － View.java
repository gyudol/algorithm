class Solution {
	static final int T = 10;
	static final int OFFSET = 2;
	
	static int N;
	static int[] buildings;
	
	static int getViewRightCount() {
		int sum = 0;
		
		for (int mid = OFFSET; mid < N - OFFSET; mid++) {
			int max = 0;
			
			for (int i = mid - OFFSET; i <= mid + OFFSET; i++) {
				if (i == mid) continue;
				
				max = Math.max(buildings[i], max);
			}
			
			if (buildings[mid] > max) sum += buildings[mid] - max;
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
	
	public static void main(String[] args) throws Exception {
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			buildings = new int[N];
			
			for (int i = 0; i < N; i++) {
				buildings[i] = readInt();
			}
			
			result.append('#').append(tc).append(' ').append(getViewRightCount()).append('\n');
		}
		
		System.out.print(result);
	}
}