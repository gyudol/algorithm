import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static char [][] grid;
	private static boolean [][][] isVisited;
	
	private static boolean promising(char cur, char next) {	// about color blindness
		if(cur == next) return true;
		if(cur == 'R' && next == 'G') return true;
		if(cur == 'G' && next == 'R') return true;
		
		return false;
	}
	
	private static int dfs(int row, int col, int isColorBlind) {
		if(isVisited[row][col][isColorBlind]) return 0;
		isVisited[row][col][isColorBlind] = true;
		
		for(int [] d : DIR) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
			if(isColorBlind == 0 && grid[row][col] != grid[nextRow][nextCol]) continue;
			if(isColorBlind == 1 && !promising(grid[row][col], grid[nextRow][nextCol])) continue;
			
			dfs(nextRow, nextCol, isColorBlind);
		}
		
		return 1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int [] area = {0, 0};
		n = Integer.parseInt(br.readLine());
		grid = new char [n][n];
		isVisited = new boolean [n][n][2];
		
		for(int i = 0; i < n; i++) grid[i] = br.readLine().toCharArray();
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				area[0] += dfs(row, col, 0);
				area[1] += dfs(row, col, 1);
			}
		}
		
		result.append(area[0]).append(' ').append(area[1]);
		
		System.out.print(result);
	}
}