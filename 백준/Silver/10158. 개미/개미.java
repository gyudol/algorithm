class Main {
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
		final int w = readInt(), h = readInt(), 
				p = readInt(), q = readInt(), t = readInt();
		
		int curX = (p + t) % (2 * w), curY = (q + t) % (2 * h);
		
		if(curX > w) curX = 2 * w - curX;
		if(curY > h) curY = 2 * h - curY;
		
		result.append(curX).append(' ').append(curY);
		System.out.print(result);
	}
}