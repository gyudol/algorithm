import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int [][] matrix;
	
	private static boolean dfs(int src, int target, boolean [] isVisited) {
		boolean exist = false;
		
		if(isVisited[src]) return exist;
		isVisited[src] = true;
		
		for(int des = 0; des < n; des++) {
			if(exist) return exist;
			if(matrix[src][des] == 0) continue;
			if(des == target) return true;
			
			exist = dfs(des, target, isVisited);
		}
		
		return exist;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		matrix = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) 
				result.append(dfs(i, j, new boolean [n]) ? 1 : 0).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}