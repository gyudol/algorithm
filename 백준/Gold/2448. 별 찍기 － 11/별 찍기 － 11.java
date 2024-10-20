import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static char[][] stars;
	
	private static void buildStars(int row, int col, int len) {
		if(len == 3) {
			stars[row][col] = '*';
			stars[row + 1][col - 1] = stars[row + 1][col + 1] = '*';
			stars[row + 2][col - 2] = stars[row + 2][col - 1] = stars[row + 2][col] 
					= stars[row + 2][col + 1] = stars[row + 2][col + 2] = '*';
			
			return;
		}
		
		int half = len / 2;
		
		buildStars(row, col, half);
		buildStars(row + half, col - half, half);
		buildStars(row + half, col + half, half);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());		
		stars = new char[N][N * 2 - 1];
		
		for(char[] row : stars) Arrays.fill(row, ' ');
		buildStars(0, N - 1, N);	// (0, N - 1) is top
		
		for(char[] row : stars) result.append(row).append('\n');
		
		System.out.print(result);
	}
}