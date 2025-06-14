import java.util.Arrays;

class Solution {
	static int N, M, K;
	static int[] arrivalTimes;
	
	static String canServeAllCustomers() {
		int curTime = 0, dishCnt = 0;
		
		for (int arrTime : arrivalTimes) {
			int mul = (arrTime - curTime) / M;
			
			curTime += mul * M;
			dishCnt += mul * K;
				
			if (dishCnt > 0) {
				dishCnt--;
			} else {
				return "Impossible";
			}
		}
		
		return "Possible";
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
			M = readInt();
			K = readInt();
			arrivalTimes = new int[N];
			
			for (int i = 0; i < N; i++) {
				arrivalTimes[i] = readInt();
			}
			Arrays.sort(arrivalTimes);
			
			result.append('#').append(tc).append(' ')
				.append(canServeAllCustomers()).append('\n');
		}
		
		System.out.print(result);
	}
}