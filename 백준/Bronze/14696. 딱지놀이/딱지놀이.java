class Main {
	static class Scab implements Comparable<Scab> {
		int star = 0, circle = 0, 
				square = 0, triangle = 0;
		
		@Override
		public int compareTo(Scab o) {
			if (star == o.star) {
				if (circle == o.circle) {
					if (square == o.square) 
						return Integer.compare(triangle, o.triangle);

					return Integer.compare(square, o.square);
				}

				return Integer.compare(circle, o.circle);
			}
			
			return Integer.compare(star, o.star);
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
	
	static Scab generate() throws Exception {
		final int M = readInt();
		Scab scab = new Scab();
		
		for (int i = 0; i < M; i++) {
			switch(readInt()) {
				case 4: scab.star++; break;
				case 3: scab.circle++; break;
				case 2: scab.square++; break;
				case 1: scab.triangle++; break;
			}
		}
		
		return scab;
	}
	
	static char getWinner(Scab A, Scab B) {
		int cmp = A.compareTo(B);
		
		if (cmp < 0) return 'B';
		else if (cmp == 0) return 'D';
		
		return 'A';
	}
	
	public static void main(String [] args) throws Exception {
		final int N = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			final Scab A = generate(), B = generate();
			
			result.append(getWinner(A, B)).append('\n');
		}
		
		System.out.print(result);
	}
}