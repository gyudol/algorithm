class Main {
	static final int LEN = 20;
	static int N;
	static boolean[] switches;
	
	static boolean isValid(int num, int offset) {
		return num - offset >= 0 && num + offset < N &&
				switches[num - offset] == switches[num + offset];
	}
	
	static void press(boolean isMan, int num) {
		if (isMan) {
			for (int i = num - 1; i < N; i += num)
				switches[i] = !switches[i];
		}
		else {
			int offset = 0;
			switches[--num] = !switches[num];
			
			while (isValid(num, ++offset)) {
				switches[num - offset] = !switches[num - offset];
				switches[num + offset] = !switches[num + offset];
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
	
	public static void main(String [] args) throws Exception {
		StringBuilder result = new StringBuilder();
		N = readInt();
		switches = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			if(readInt() == 1) switches[i] = true;
		}
		
		final int M = readInt();
		
		for (int i = 0; i < M; i++) press(readInt() == 1, readInt());
		
		for (int i = 0; i < N / LEN; i++) {
			for (int j = 0; j < LEN; j++) 
				result.append(switches[i * LEN + j] ? 1 : 0).append(' ');
			result.append('\n');
		}
		
		for (int i = 0; i < N % LEN; i++) 
			result.append(switches[N / LEN * LEN + i] ? 1 : 0).append(' ');
		System.out.print(result);
	}
}