class Solution {
	static int M;
	static int max;
	static char[] digits;
	
	static void swap(int i, int j) {
		char temp = digits[i];
		digits[i] = digits[j];
		digits[j] = temp;
	}
	
	static void combination(int depth) {
		if (depth == M) {
			max = Math.max(Integer.parseInt(new String(digits)), max);
			return;
		}
		
		for (int i = 0; i < digits.length; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[i] == digits[j]) continue;
				
				swap(i, j);
				combination(depth + 1);
				swap(i, j);
			}
		}
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
			final int N = readInt();
			M = readInt();
			max = Integer.MIN_VALUE;
			digits = Integer.toString(N).toCharArray();
			
			// 자릿수 이상의 교환은 중복된 조합만 반복하므로 제한
			M = Math.min(digits.length, M);
			combination(0);
			
			result.append('#').append(tc).append(' ').append(max).append('\n');
		}
		
		System.out.print(result);
	}
}