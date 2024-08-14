import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 26;
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int r;
	private static int c;
	private static char [][] board;
	
	private static int dfs(int depth, int row, int col, boolean [] isVisited) {
		int max = depth;
		
		for(int [] d : DIR) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
			
			int idx = board[nextRow][nextCol] - 'A';
			
			if(isVisited[idx]) continue;
			isVisited[idx] = true;
			
			max = Math.max(max, dfs(depth + 1, nextRow, nextCol, isVisited));
			
			isVisited[idx] = false;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
		board = new char [r][c];
		
		for(int i = 0; i < r; i++) board[i] = br.readLine().toCharArray();
		
		System.out.print(dfs(0, 0, -1, new boolean [LEN]));
	}
}