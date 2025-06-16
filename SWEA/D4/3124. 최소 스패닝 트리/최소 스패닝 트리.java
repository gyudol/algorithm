import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
	static int V, E;
	static ArrayList<ArrayList<Node>> edges;
	
	static long prim() {
		PriorityQueue<Node> heap = new PriorityQueue<>();
		boolean[] isVisited = new boolean[V + 1];
		long costSum = 0;
		
		isVisited[1] = true;
		for (Node src : edges.get(1)) {
			heap.offer(new Node(src.v,  src.dist));
		}
		
		while (!heap.isEmpty()) {
			Node node = heap.poll();
			int u = node.v, dist = node.dist;
			
			if (isVisited[u]) continue;
			
			isVisited[u] = true;
			costSum += dist;
			
			for (Node des : edges.get(u)) {
				int v = des.v;
				
				if (isVisited[v]) continue;
				
				heap.offer(new Node(v, des.dist));
			}
		}
		
		return costSum;
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
			edges = new ArrayList<>();
			
			for (int i = 0; i <= V; i++) {
				edges.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				int u = readInt(), v = readInt(), dist = readInt();
				
				edges.get(u).add(new Node(v, dist));
				edges.get(v).add(new Node(u, dist));
			}
			
			result.append('#').append(tc).append(' ')
				.append(prim()).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class Node implements Comparable<Node> {
		int v, dist;
		
		Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(dist, other.dist);
		}
	}
}