import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private static class State implements Comparable<State> {
		private int row;
		private int col;
		private int rupoor;
		
		private State(int row, int col, int rupoor) {
			this.row = row;
			this.col = col;
			this.rupoor = rupoor;
		}
		
		@Override
		public int compareTo(State other) {
			return Integer.compare(this.rupoor, other.rupoor);
		}
	}
	
	private static int dijkstra(int n, int[][] rupoors) {
		PriorityQueue<State> minHeap = new PriorityQueue<>();
		int[][] dist = new int[n][n];

		minHeap.offer(new State(0, 0, dist[0][0] = rupoors[0][0]));
		for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
		
		while(!minHeap.isEmpty()) {
			State state = minHeap.poll();
			int row = state.row, col = state.col, rupoor = state.rupoor;
			
			if(row == n - 1 && col == n - 1) return rupoor;
			
			for(int[] d : DIR) {
				int nextRow = row + d[0], nextCol = col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
				
				int nextRupoor = rupoor + rupoors[nextRow][nextCol];
				
				if(nextRupoor >= dist[nextRow][nextCol]) continue;
				dist[nextRow][nextCol] = nextRupoor;
				minHeap.offer(new State(nextRow, nextCol, nextRupoor));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int tc = 1;
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			int[][] rupoors = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < n; j++) rupoors[i][j] = Integer.parseInt(st.nextToken());
			}
			
			result.append('P').append('r').append('o').append('b').append('l').append('e').append('m')
				.append(' ').append(tc++).append(':').append(' ').append(dijkstra(n, rupoors)).append('\n');
		}
		
		System.out.print(result);
	}
}