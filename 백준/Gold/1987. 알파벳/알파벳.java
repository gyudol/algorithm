import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int R, C;
	static char[][] board;
	
	static int dfs(int row, int col, int depth, boolean[] isVisited) {
		int max = depth;
		
		for (int[] d : DIR) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C
					|| isVisited[board[nr][nc]]) continue;
			
			isVisited[board[nr][nc]] = true;
			max = Math.max(dfs(nr, nc, depth + 1, isVisited), max);
			isVisited[board[nr][nc]] = false;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int row = 0; row < R; row++) board[row] = br.readLine().toCharArray();
		
		boolean[] isVisited = new boolean['Z' + 1];
		isVisited[board[0][0]] = true;
		
		System.out.print(dfs(0, 0, 1, isVisited));
	}
}