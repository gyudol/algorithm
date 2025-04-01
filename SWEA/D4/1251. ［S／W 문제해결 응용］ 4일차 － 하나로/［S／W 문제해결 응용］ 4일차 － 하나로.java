import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static class Node {
		int x, y;
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v;
		long squaredW;
		
		Edge(int u, int v, long squaredW) {
			this.u = u;
			this.v = v;
			this.squaredW = squaredW;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Long.compare(squaredW, other.squaredW);
		}
	}
	
	static int[] parents;
	static List<Edge> edges;
	
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
	
	static long mst(double E) {
		double length = 0;
		
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			
			if (merge(edge.u, edge.v)) length += edge.squaredW;
		}
		
		return Math.round(E * length);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N];
			edges = new ArrayList<>();
			parents = new int[N];
			
			for (int i = 0; i < N; i++) {
				parents[i] = i;
				nodes[i] = new Node();
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) nodes[i].x = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) nodes[i].y = Integer.parseInt(st.nextToken());
			
			for (int u = 0; u < N; u++) {
				for (int v = u + 1; v < N; v++) {
					long distX = nodes[v].x - nodes[u].x,
							distY = nodes[v].y - nodes[u].y;
					
					edges.add(new Edge(u, v, distX * distX + distY * distY));
				}
			}
			
			Collections.sort(edges);
			result.append('#').append(tc).append(' ')
				.append(mst(Double.parseDouble(br.readLine()))).append('\n');
		}
		
		System.out.print(result);
	}
}