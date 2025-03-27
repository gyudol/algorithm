import java.util.Arrays;

class Solution {
	static int V, E;
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int u, v, weight;
		
		Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int root(int u) {
		if (parents[u] == u) return u;
		return parents[u] = root(parents[u]);
	}
	
	static boolean merge(int u, int v) {
		int rootU = root(u), rootV = root(v);
		
		if (rootU == rootV) return false;
		parents[rootV] = rootU;
		
		return true;
	}
	
	static long kruskal(Edge[] edges) {
		int cnt = 0;
		long dist = 0;
		
		for (Edge edge : edges) {
			if (merge(edge.u, edge.v)) {
				dist += edge.weight;
				
				if (++cnt == V - 1) break;
			}
		}
		
		return dist;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		boolean isNegative = c == 45;
		
		if (isNegative) c = System.in.read();
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return isNegative ? ~n + 1 : n;
	}
	
	public static void main(String[] args) throws Exception {
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			V = readInt();
			E = readInt();
			parents = new int[V + 1];
			Edge[] edges = new Edge[E];
			
			for (int i = 1; i <= V; i++) parents[i] = i;
			for (int i = 0; i < E; i++)
				edges[i] = new Edge(readInt(), readInt(), readInt());
			Arrays.sort(edges);
			
			result.append('#').append(tc).append(' ').append(kruskal(edges)).append('\n');
		}
		
		System.out.print(result);
	}
}