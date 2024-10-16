import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] confetti;
	private static int minus = 0;
	private static int zero = 0;
	private static int plus = 0;
	
	private static void compress(int srcRow, int srcCol, int size) {
		int tmp = confetti[srcRow][srcCol];
		
		for(int row = srcRow; row < srcRow + size; row++) {
			for(int col = srcCol; col < srcCol + size; col++) {
				if(confetti[row][col] == tmp) continue;
				
				int triple = size / 3;
				
				compress(srcRow, srcCol, triple);
				compress(srcRow, srcCol + triple, triple);
				compress(srcRow, srcCol + 2 * triple, triple);
				compress(srcRow + triple, srcCol, triple);
				compress(srcRow + triple, srcCol + triple, triple);
				compress(srcRow + triple, srcCol + 2 * triple, triple);
				compress(srcRow + 2 * triple, srcCol, triple);
				compress(srcRow + 2 * triple, srcCol + triple, triple);
				compress(srcRow + 2 * triple, srcCol + 2 * triple, triple);
				
				return;
			}
		}
		
		if(tmp < 0) minus++;
		else if(tmp == 0) zero++;
		else plus++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		confetti = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) confetti[i][j] = Integer.parseInt(st.nextToken());
		}
		
		compress(0, 0, N);
		
		result.append(minus).append('\n').append(zero).append('\n').append(plus);
		System.out.print(result);
	}
}