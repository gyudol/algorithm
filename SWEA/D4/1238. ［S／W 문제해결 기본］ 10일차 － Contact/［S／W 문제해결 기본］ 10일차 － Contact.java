import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
	static final int T = 10;
	static final int N = 100;
	static ArrayList<ArrayList<Integer>> edges;
	
	static int bfs(int src) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] isVisited = new int[N + 1];
		
		q.offer(src);
		int maxWeight = isVisited[src] = 1;
		
		while (!q.isEmpty()) {
			int u = q.poll();
			maxWeight = Math.max(maxWeight, isVisited[u]);
			
			for (int v : edges.get(u)) {
				if (isVisited[v] > 0) continue;
				
				isVisited[v] = isVisited[u] + 1;
				q.offer(v);
			}
		}
		
		for (int v = N; v >= 0; v--) {
			if (isVisited[v] == maxWeight) return v;
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
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			final int M = readInt(), SOURCE = readInt();
			edges = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) edges.add(new ArrayList<>());
			for (int i = 0; i < M / 2; i++) edges.get(readInt()).add(readInt());
		
			result.append('#').append(tc).append(' ').append(bfs(SOURCE)).append('\n');
		}
		
		System.out.print(result);
	}
}