import java.util.ArrayList;

class Solution {
	static int N, M;
	static ArrayList<ArrayList<Integer>> edges;
	
	static int dfs(int u, int depth, boolean[] isVisited) {
		int max = depth;
		
		for (int v : edges.get(u)) {
			if (isVisited[v]) continue;
			
			isVisited[v] = true;
			max = Math.max(dfs(v, depth + 1, isVisited), max);
			isVisited[v] = false;
		}
		
		return max;
	}
	
	static int getMaxDistance() {
		int max = 0;
		
		for (int u = 1; u <= N; u++) {
			boolean[] isVisited = new boolean[N + 1];
			
			isVisited[u] = true;
			max = Math.max(dfs(u, 1, isVisited), max);
		}
		
		return max;
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
			edges = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) {
				edges.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				int u = readInt(), v = readInt();
				
				edges.get(u).add(v);
				edges.get(v).add(u);
			}
			
			result.append('#').append(tc).append(' ')
				.append(getMaxDistance()).append('\n');
		}
		
		System.out.print(result);
	}
}