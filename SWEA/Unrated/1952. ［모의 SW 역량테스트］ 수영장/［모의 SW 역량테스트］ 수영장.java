import java.util.Arrays;

class Solution {
	static final int MONTH = 12;
	static final int QUARTER = 3;
	static final int RATE_TYPE = 4;
	
	static int[] rates = new int[RATE_TYPE];
	static int[] usagePlans = new int[MONTH + 1];
	
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
			int[] dp = new int[MONTH + 1];
			
			for (int i = 0; i < RATE_TYPE; i++) rates[i] = readInt();
			for (int month = 1; month <= MONTH; month++) usagePlans[month] = readInt();
			
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for (int i = 1; i <= MONTH; i++) {
				dp[i] = Math.min(dp[i - 1] + 
						Math.min(usagePlans[i] * rates[0], rates[1]), dp[i]);
				
				if (i >= QUARTER) dp[i] = Math.min(dp[i - QUARTER] + rates[2], dp[i]);
			}
			
			result.append('#').append(tc).append(' ')
				.append(Math.min(dp[MONTH], rates[3])).append('\n');
		}
		
		System.out.print(result);
	}
}