import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N;
	static char[][] painting;
	
	static boolean dfs(int row, int col, char base, boolean[][] isVisited) {
		if (isVisited[row][col]) return false;
		isVisited[row][col] = true;
		
		for (int[] d : DIR) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || painting[nr][nc] != base) continue;
			dfs(nr, nc, base, isVisited);
		}
		
		return true;
	}
	
	static int getAreaCnt(boolean isColorBlind) {
		boolean[][] isVisited = new boolean[N][N];
		int areaCnt = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (dfs(row, col, painting[row][col], isVisited)) areaCnt++;
				if (painting[row][col] == 'G' && !isColorBlind) painting[row][col] = 'R';
			}
		}
		
		return areaCnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		painting = new char[N][N];
		
		for (int row = 0; row < N; row++) painting[row] = br.readLine().toCharArray();
		
		result.append(getAreaCnt(false)).append(' ').append(getAreaCnt(true));
		System.out.print(result);
	}
}