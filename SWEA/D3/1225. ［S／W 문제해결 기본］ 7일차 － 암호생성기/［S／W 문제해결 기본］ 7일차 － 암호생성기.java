class Solution {
	static final int T = 10;
	static final int N = 8;
	static final int CYCLE = 5;
	
	static int[] numbers = new int[N];
	
	static int generatePassword() {
		int peekIdx = 0, diff = 1;

		while (numbers[peekIdx] > diff) {
			numbers[peekIdx] -= diff;
			peekIdx = (peekIdx + 1) % N;
			diff = diff % CYCLE + 1;
		}
		
		numbers[peekIdx] = 0;
		return peekIdx + 1;
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
		int tc = 0;
		StringBuilder result = new StringBuilder();
		
		while (tc < T) {
			tc = readInt();
			
			for (int i = 0; i < N; i++) {
				numbers[i] = readInt();
			}
			
			int peekIdx = generatePassword();

			result.append('#').append(tc);
			for (int i = 0; i < N; i++) {
				result.append(' ').append(numbers[(peekIdx + i) % N]);
			}
			result.append('\n');
		}
		
		System.out.print(result);
	}
}