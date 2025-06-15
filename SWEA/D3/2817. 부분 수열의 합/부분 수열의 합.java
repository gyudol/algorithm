class Solution {
	static int N, K;
	static int[] seq;
	
	static int countSubsetsWithSumK(int src, int sum) {
		if (sum > K) return 0;
		if (sum == K) return 1;
		
		int cnt = 0;
		
		for (int i = src; i < N; i++) {
			cnt += countSubsetsWithSumK(i + 1, sum + seq[i]);
		}
		
		return cnt;
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
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			K = readInt();
			seq = new int[N];
			
			for (int i = 0; i < N; i++) {
				seq[i] = readInt();
			}
			
			result.append('#').append(tc).append(' ')
				.append(countSubsetsWithSumK(0, 0)).append('\n');
		}
		
		System.out.print(result);
	}
}