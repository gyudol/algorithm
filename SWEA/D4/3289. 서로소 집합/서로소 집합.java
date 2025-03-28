class Solution {
	static int[] parent;
	
	static int root(int node) {
		if (parent[node] == node) return node;
		
		return parent[node] = root(parent[node]);
	}
	
	static boolean isConnected(int a, int b) {
		return root(a) == root(b);
	}

	static void merge(int a, int b) {
		if (isConnected(a, b)) return;
		
		parent[root(b)] = root(a);
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
			final int N = readInt(), M = readInt();
			parent = new int[N + 1];
			
			for (int i = 1; i <= N; i++) parent[i] = i;
			result.append('#').append(tc).append(' ');
			
			for (int i = 0; i < M; i++) {
				switch (readInt()) {
					case 0: merge(readInt(), readInt()); break;
					case 1: result.append(isConnected(readInt(), readInt()) ? 1 : 0); break;
				}
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}