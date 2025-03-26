class Solution {
	static int[] parent;
	
	static int root(int node) {
		if (parent[node] == node) return node;
		
		return parent[node] = root(parent[node]);
	}
	
	static boolean isConnected(int a, int b) {
		return root(a) == root(b);
	}
	
	static boolean merge(int a, int b) {
		if (isConnected(a, b)) return false;
		
		parent[root(b)] = root(a);
		return true;
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
			int cluster = N;
			
			for (int i = 1; i <= N; i++) parent[i] = i;
			
			for (int i = 0; i < M; i++) {
				if (merge(readInt(), readInt())) cluster--;
			}
			
			result.append('#').append(tc).append(' ').append(cluster).append('\n');
		}
		
		System.out.print(result);
	}
}