class Main {
	static final int GRADE = 6;
	static final int GENDER = 2;
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String [] args) throws Exception {
		final int N = readInt(), K = readInt();
		int[][] students = new int[GENDER][GRADE + 1];
		int roomCnt = 0;
		
		for (int i = 0; i < N; i++) students[readInt()][readInt()]++;
		
		for (int grade = 1; grade <= GRADE; grade++) {
			for (int gender = 0; gender < GENDER; gender++) {
				roomCnt += students[gender][grade] / K;
				
				if (students[gender][grade] % K > 0) roomCnt++;
			}
		}
		
		System.out.print(roomCnt);
	}
}