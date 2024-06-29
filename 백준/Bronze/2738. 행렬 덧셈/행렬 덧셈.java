import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		int [][] matrix = new int [n][m];
		
		for(int i = 0; i < n * 2; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) matrix[i % n][j] += Integer.parseInt(st.nextToken());
		}
		
		for(int [] row : matrix) {
			for(int num : row) result.append(num).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}