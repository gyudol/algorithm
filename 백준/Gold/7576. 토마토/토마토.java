import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N, M;
	static int[][] tomatoes;
	
	static class Tomato {
		int row, col, day;
		
		Tomato(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	static int bfs(Queue<Tomato> q, int remainder) {
		if (remainder == 0) return 0;
		
		while (!q.isEmpty()) {
			Tomato tomato = q.poll();
			int row = tomato.row, col = tomato.col, day = tomato.day;
			
			for (int[] d : DIR) {
				int nr = row + d[0], nc = col + d[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M
						|| tomatoes[nr][nc] != 0) continue;
				if (--remainder == 0) return day + 1;
				
				tomatoes[nr][nc] = 1;
				q.offer(new Tomato(nr, nc, day + 1));
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
	
	public static void main(String [] args) throws Exception {
		M = readInt();
		N = readInt();
		tomatoes = new int[N][M];
		Queue<Tomato> q = new ArrayDeque<>();
		int remainder = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				tomatoes[row][col] = readInt();
				
				if (tomatoes[row][col] == 0) remainder++;
				else if (tomatoes[row][col] == 1) q.offer(new Tomato(row, col, 0));
			}
		}
		
		System.out.print(bfs(q, remainder));
	}
}