import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	static final int T = 10;
	static final int N = 16;
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int[][] maze = new int[N][N];
	
	static int isReachable(Coord src) {
		boolean[][] isVisited = new boolean[N][N];
		Queue<Coord> q = new ArrayDeque<>();
		
		isVisited[src.row][src.col] = true;
		q.offer(src);
		
		while (!q.isEmpty()) {
			Coord coord = q.poll();
			int row = coord.row, col = coord.col;
			
			if (maze[row][col] == 3) return 1;
			
			for (int[] d : DIRECTIONS) {
				int nr = row + d[0], nc = col + d[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N
						|| maze[nr][nc] == 1 || isVisited[nr][nc]) continue;
				
				isVisited[nr][nc] = true;
				q.offer(new Coord(nr, nc));
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int tc = 0;
		
		while (tc < T) {
			tc = Integer.parseInt(br.readLine());
			Coord src = null;
			
			for (int row = 0; row < N; row++) {
				String line = br.readLine();
				
				for (int col = 0; col < N; col++) {
					maze[row][col] = line.charAt(col) - '0';
					
					if (maze[row][col] == 2) {
						src = new Coord(row, col);
					}
				}
			}
			
			result.append('#').append(tc).append(' ')
				.append(isReachable(src)).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class Coord {
		int row, col;
		
		Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}