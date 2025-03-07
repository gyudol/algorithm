import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static final int[][] DIR = {{-1, 1}, {0, 1}, {1, 1}};
	static int R, C;
	static char[][] board;
	static boolean[][] isVisited;
	
	static boolean connectPipes(int row, int col) {
		if (col == C - 1) return true;
		
		for (int[] d : DIR) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C 
					|| board[nr][nc] == 'x' || isVisited[nr][nc]) continue;
			isVisited[nr][nc] = true;
			
			if (connectPipes(nr, nc)) return true;
		}
		
		return false;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pipeLines = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		isVisited = new boolean[R][C];
		
		for (int row = 0; row < R; row++) board[row] = br.readLine().toCharArray();
		
		for (int row = 0; row < R; row++) {
			if (connectPipes(row, 0)) pipeLines++;
		}
		
		System.out.print(pipeLines);
	}
}