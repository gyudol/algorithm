import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	static int N, M, P, Q;
	static ArrayList<ArrayList<Node>> edges;
	static int[] houses;
	static int[] stores;
	static boolean[] isHouse;
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] minDist = new int[N + 1];
		
		Arrays.fill(minDist, Integer.MAX_VALUE);
		for (int store : stores) {
			minDist[store] = 0;
			pq.offer(new Node(store, 0));
		}
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v, dist = cur.dist;
			
			if (isHouse[u]) return u;
			
			for (Node next : edges.get(u)) {
				int v = next.v;
				
				if (dist + next.dist >= minDist[v]) continue;
				
				minDist[v] = dist + next.dist;
				pq.offer(new Node(v, minDist[v]));
			}
		}
		
		return -1;
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
		M = readInt();
		edges = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int u = readInt(), v = readInt(), dist = readInt();
			
			edges.get(u).add(new Node(v, dist));
			edges.get(v).add(new Node(u, dist));
		}
		
		P = readInt();
		Q = readInt();
		houses = new int[P];
		stores = new int[Q];
		isHouse = new boolean[N + 1];
		
		for (int i = 0; i < P; i++) {
			houses[i] = readInt();
			isHouse[houses[i]] = true;
		}
		for (int i = 0; i < Q; i++) {
			stores[i] = readInt();
		}
		
		System.out.print(dijkstra());
	}
	
	static class Node implements Comparable<Node> {
		int v, dist;
		
		Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			if (dist == other.dist) return Integer.compare(v, other.v);
			return Integer.compare(dist, other.dist);
		}
	}
}