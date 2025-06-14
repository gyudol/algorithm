import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static final int MAX_MEMORY = 15;
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int R, C;
	static Queue<State> q;
	static char[][] codes;
	static boolean[][][][] isVisited;
	
	static void command(int row, int col, int newMem, int newDir) {
		int nr = (row + DIRECTIONS[newDir][0] + R) % R,
				nc = (col + DIRECTIONS[newDir][1] + C) % C;
		
		if (isVisited[nr][nc][newMem][newDir]) return;
		
		isVisited[nr][nc][newMem][newDir] = true;
		q.offer(new State(nr, nc, newMem, newDir));
	}
	
	// DFS는 재귀 호출 깊이 제한으로 Stack Overflow 발생.
	static boolean bfs() {
		q.offer(new State(0, 0, 0, 0));
		isVisited[0][0][0][0] = true;
		
		while (!q.isEmpty()) {
			State state = q.poll();
			int row = state.row, col = state.col, mem = state.mem,
					dir = state.dir, newMem = mem, newDir = dir;
			char code = codes[row][col];
			
			switch (code) {
				case '@': return true;
				case '<': newDir = 2; break;
				case '>': newDir = 0; break;
				case '^': newDir = 3; break;
				case 'v': newDir = 1; break;
				case '_': newDir = mem == 0 ? 0 : 2; break;
				case '|': newDir = mem == 0 ? 1 : 3; break;
				case '+': newMem = (mem + 1) % (MAX_MEMORY + 1); break;
				case '-': newMem = (mem + MAX_MEMORY) % (MAX_MEMORY + 1); break;
				default:
					if (code >= '0' && code <= '9') newMem = code - '0';				
			}
			
			if (code == '?') {
				for (int d = 0; d < DIRECTIONS.length; d++) {
					command(row, col, newMem, d);
				}	
			} else {
				command(row, col, newMem, newDir);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			q = new ArrayDeque<>();
			codes = new char[R][C];
			isVisited = new boolean[R][C][MAX_MEMORY + 1][DIRECTIONS.length];			

			for (int row = 0; row < R; row++) {
				codes[row] = br.readLine().toCharArray();
			}
			
			result.append('#').append(tc).append(' ')
				.append(bfs() ? "YES" : "NO").append('\n');
		}
		
		System.out.print(result);
	}
	
	static class State {
		int row, col, mem, dir;
		
		State(int row, int col, int mem, int dir) {
			this.row = row;
			this.col = col;
			this.mem = mem;
			this.dir = dir;
		}
	}
}