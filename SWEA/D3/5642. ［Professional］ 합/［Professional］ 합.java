class Solution {
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		boolean isNegative = c == 45;
		
		if (isNegative) c = System.in.read();
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return isNegative ? ~n + 1 : n;
	}
	
	public static void main(String[] args) throws Exception {
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			final int N = readInt();
			int[] seq = new int[N];
			int[] dp = new int[N];
			
			for (int i = 0; i < N; i++) {
				seq[i] = readInt();
			}

			int max = dp[0] = seq[0];
			
			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(seq[i], dp[i - 1] + seq[i]);
				max = Math.max(dp[i], max);
			}
			
			result.append('#').append(tc).append(' ').append(max).append('\n');
		}
		
		System.out.print(result);
	}
}