import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_SIZE = 6;
	private static final int[][] DIR = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	private static int N;
	private static int[][] sea;
	private static int[] fishCnt;
	
	private static class State implements Comparable<State> {
		private int row;
		private int col;
		private int time;
		
		private State(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
		
		@Override
		public int compareTo(State other) {
			if(this.time == other.time) {
				if(this.row == other.row) return Integer.compare(col, other.col);
				return Integer.compare(row, other.row);
			}
			
			return Integer.compare(time, other.time);
		}
	}

	private static boolean isPromising(int sharkSize) {
		for(int fishSize = 1; fishSize < sharkSize; fishSize++) {
			if(fishCnt[fishSize] > 0) return true;
		}
		
		return false;
	}
	
	private static State bfs(State shark, int size) {
		boolean[][] isVisited = new boolean[N][N];
		PriorityQueue<State> minHeap = new PriorityQueue<>();
		
		minHeap.offer(new State(shark.row, shark.col, shark.time));
		isVisited[shark.row][shark.col] = true;
		
		while(!minHeap.isEmpty()) {
			State state = minHeap.poll();
			int row = state.row, col = state.col, time = state.time;
			
			if(sea[row][col] > 0 && sea[row][col] < size) {
				fishCnt[sea[row][col]]--;
				sea[row][col] = 0;
				
				return state;
			}
			
			for(int[] d : DIR) {
				int nextRow = state.row + d[0], nextCol = state.col + d[1];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
						|| isVisited[nextRow][nextCol] || sea[nextRow][nextCol] > size) continue;
				isVisited[nextRow][nextCol] = true;
				
				minHeap.offer(new State(nextRow, nextCol, time + 1));
			}
		}
		
		return shark;
	}
	
	private static int sharkSimulator(State shark) {
		int size = 2, exp = 0;
		
		while(true) {
			if(!isPromising(size)) break;
			
			int prevRow = shark.row, prevCol = shark.col;
			shark = bfs(shark, size);
			
			if(prevRow == shark.row && prevCol == shark.col) break;
			if(size > MAX_SIZE) continue;
			if(++exp >= size) {
				size++;
				exp = 0;
			}
		}
		
		return shark.time;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		fishCnt = new int[MAX_SIZE + 1];
		State cur = null;
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) {
				sea[row][col] = Integer.parseInt(st.nextToken());
				
				if(sea[row][col] == 9) {
					cur = new State(row, col, 0);
					sea[row][col] = 0;
				}
				else if(sea[row][col] != 0) fishCnt[sea[row][col]]++;;
			}
		}
		
		System.out.print(sharkSimulator(cur));
	}
}