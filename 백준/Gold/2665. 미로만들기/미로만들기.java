import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int N;
	private static char[][] maze;
	
	private static class Room implements Comparable<Room> {
		private int row;
		private int col;
		private int changedCnt;
		
		private Room(int row, int col, int changedCnt) {
			this.row = row;
			this.col = col;
			this.changedCnt = changedCnt;
		}
		
		@Override
		public int compareTo(Room other) {
			return Integer.compare(this.changedCnt, other.changedCnt);
		}
	}
	
	private static int difkstra() {
		boolean[][] isVisited = new boolean[N][N];
		PriorityQueue<Room> minHeap = new PriorityQueue<>();
		
		minHeap.offer(new Room(0, 0, 0));
		isVisited[0][0] = true;
		
		while(!minHeap.isEmpty()) {
			Room room = minHeap.poll();
			int row = room.row, col = room.col, changedCnt = room.changedCnt;
			
			if(row == N - 1 && col == N - 1) return changedCnt;
			
			for(int[] d : DIR) {
				int nextRow = row + d[0], nextCol = col + d[1];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
						|| isVisited[nextRow][nextCol]) continue;
				isVisited[nextRow][nextCol] = true;
				int nextChangedCnt = changedCnt + (maze[nextRow][nextCol] == '1' ? 0 : 1);
				
				minHeap.offer(new Room(nextRow, nextCol, nextChangedCnt));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maze = new char[N][N];
		
		for(int i = 0; i < N; i++) maze[i] = br.readLine().toCharArray();
		
		System.out.print(difkstra());
	}
}