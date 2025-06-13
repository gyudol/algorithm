import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static Node[] nodes;
	
	static double getSquaredDistance(int u, int v) {
		int xDiff = nodes[u].x - nodes[v].x,
				yDiff = nodes[u].y - nodes[v].y;
		
		return xDiff * 1L * xDiff + yDiff * 1L * yDiff;
	}
	
	static double prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[N];
		double[] dist = new double[N];
		double costSum = 0;
		int cnt = 1;
		
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[0] = 0;
		isVisited[0] = true;
		
		for (int v = 1; v < N; v++) {
			pq.offer(new Edge(v, getSquaredDistance(0, v)));
		}
		
		while (cnt < N) {
			Edge edge = pq.poll();
			int u = edge.v;
			double cost = edge.squaredDist;
			
			if (isVisited[u]) continue;
			
			isVisited[u] = true;
			costSum += cost;
			cnt++;
			
			for (int v = 1; v < N; v++) {
				double squaredDist = getSquaredDistance(u, v);
				
				if (isVisited[v] || dist[v] <= squaredDist) continue;
				
				dist[v] = squaredDist;
				pq.offer(new Edge(v, squaredDist));
			}
		}
		
		return costSum;
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
		double squaredDist;
		
		Edge(int v, double squaredDist) {
			this.v = v;
			this.squaredDist = squaredDist;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Double.compare(squaredDist, other.squaredDist);
		}
	}
}