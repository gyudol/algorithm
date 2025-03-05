class Main {
	static int N;
	static int[][] cities;
	static int min;
	
	static void travel(int src, int u, int sum, int depth, boolean[] isVisited) {
		if (sum >= min) return;
		if (depth == N && cities[u][src] > 0) {
			min = Math.min(sum + cities[u][src], min);
			return;
		}
		
		for (int v = 0; v < N; v++) {
			if (v == src || isVisited[v] || cities[u][v] == 0) continue;
			
			isVisited[v] = true;
			travel(src, v, sum + cities[u][v], depth + 1, isVisited);
			isVisited[v] = false;
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
		N = readInt();
		cities = new int[N][N];
		min = Integer.MAX_VALUE;
		
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < N; v++) cities[u][v] = readInt();
		}
		for (int u = 0; u < N; u++) travel(u, u, 0, 1, new boolean[N]);

		System.out.print(min);
	}
}