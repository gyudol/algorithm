import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	static final int[][][] PIPES = {null, {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, {{-1, 0}, {1, 0}},
			{{0, -1}, {0, 1}}, {{-1, 0}, {0, 1}}, {{1, 0}, {0, 1}}, {{0, -1}, {1, 0}}, {{0, -1}, {-1, 0}}};
	
	static int N, M, R, C, L;
	static int[][] map;
	
	static class Position {
		int row, col, dist;
		
		Position(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	
	static boolean isReachable(int r, int c, int tr, int tc) {
		if (map[tr][tc] == 0) return false;
		
		int rowDiff = r - tr, colDiff = c - tc;
		
		for (int[] pipe : PIPES[map[tr][tc]]) {
			if (rowDiff == pipe[0] && colDiff == pipe[1]) return true;
		}
		
		return false;
	}
	
	static int bfs() {
		Queue<Position> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
		int reachCnt = 1;
		
		q.offer(new Position(R, C, 1));
		isVisited[R][C] = true;
		
		while (!q.isEmpty()) {
			Position pos = q.poll();
			int cur = map[pos.row][pos.col];
			
			if (pos.dist == L) continue;
			
			for (int[] pipe : PIPES[cur]) {
				int nr = pos.row + pipe[0], nc = pos.col + pipe[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M ||
						!isReachable(pos.row, pos.col, nr, nc) || isVisited[nr][nc]) continue;
				
				isVisited[nr][nc] = true;
				reachCnt++;
				q.offer(new Position(nr, nc, pos.dist + 1));
			}
		}
		
		return reachCnt;
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
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			M = readInt();
			R = readInt();
			C = readInt();
			L = readInt();
			map = new int[N][M];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					map[row][col] = readInt();
				}
			}
			
			result.append('#').append(tc).append(' ').append(bfs()).append('\n');
		}
		
		System.out.print(result);
	}
}