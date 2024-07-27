import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static char [][] campus;
	private static int n;
	private static int m;
	
	private static int dfs(int row, int col, boolean [][] isVisited) {
		int peopleCnt = 0;
		
		if(isVisited[row][col]) return peopleCnt;
		isVisited[row][col] = true;
		
		if(campus[row][col] == 'P') peopleCnt++;
		
		for(int [] d : DIR) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m 
					|| campus[nextRow][nextCol] == 'X') continue;
			
			peopleCnt += dfs(nextRow, nextCol, isVisited);
		}
		
		return peopleCnt;
	}

	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		campus = new char [n][m];
		int srcRow = -1, srcCol = -1;
		
		for(int i = 0; i < n; i++) {
			campus[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				if(campus[i][j] == 'I') {
					srcRow = i;
					srcCol = j;
				}
			}
		}
		
		int peopleCnt = dfs(srcRow, srcCol, new boolean [n][m]);
		System.out.print(peopleCnt == 0 ? "TT" : peopleCnt);
	}
}