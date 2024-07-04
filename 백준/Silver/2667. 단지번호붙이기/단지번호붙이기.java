import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static int [][] map;
	private static boolean [][] isVisited;
	
	private static int dfs(int srcRow, int srcCol) {
		if(isVisited[srcRow][srcCol] || map[srcRow][srcCol] == 0) return 0;
		isVisited[srcRow][srcCol] = true;
		
		int cnt = 1;
		
		for(int [] d : DIR) {
			int nextRow = srcRow + d[0];
			int nextCol = srcCol + d[1];
			
			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
			
			cnt += dfs(nextRow, nextCol);
		}
		
		return cnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		isVisited = new boolean [n][n];
		List<Integer> complex = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(""))
					.mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int house = dfs(i, j);
				
				if(house > 0) complex.add(house);
			}
		}
		
		Collections.sort(complex);
		result.append(complex.size()).append('\n');
		for(int house : complex) result.append(house).append('\n');
		
		System.out.print(result);
	}
}