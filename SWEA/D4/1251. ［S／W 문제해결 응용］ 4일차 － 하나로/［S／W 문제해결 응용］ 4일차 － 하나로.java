import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static Node[] nodes;
	
	static double getDistance(int u, int v) {
		int xDiff = nodes[u].x - nodes[v].x,
				yDiff = nodes[u].y - nodes[v].y;
		
		return Math.sqrt(xDiff * 1L * xDiff + yDiff * 1L * yDiff);
	}
	
	static double prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[N];
		double minCost = 0;
		int cnt = 1;
		
		isVisited[0] = true;
		for (int v = 1; v < N; v++) {
			pq.offer(new Edge(v, getDistance(0, v)));
		}
		
		while (cnt < N) {
			Edge edge = pq.poll();
			int u = edge.v;
			double cost = edge.cost;
			
			if (isVisited[u]) continue;
			isVisited[u] = true;
			minCost += cost * cost;
			cnt++;
			
			for (int v = 1; v < N; v++) {
				if (isVisited[v]) continue;
				
				pq.offer(new Edge(v, getDistance(u, v)));
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N];
			
			for (int i = 0; i < N; i++) {
				nodes[i] = new Node();
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nodes[i].x = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nodes[i].y = Integer.parseInt(st.nextToken());
			}
			
			result.append('#').append(tc).append(' ')
				.append(Math.round(Double.parseDouble(br.readLine()) * prim())).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class Node {
		int x, y;
	}
	
	static class Edge implements Comparable<Edge> {
		int v;
		double cost;
		
		Edge(int v, double cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Double.compare(cost, other.cost);
		}
	}
}