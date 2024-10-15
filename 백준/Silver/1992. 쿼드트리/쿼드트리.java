import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static StringBuilder result;
	private static int N;
	private static int[][] video;
	
	private static void compress(int srcRow, int srcCol, int size) {
		int comp = video[srcRow][srcCol];
		
		for(int row = srcRow; row < srcRow + size; row++) {
			for(int col = srcCol; col < srcCol + size; col++) {
				if(video[row][col] != comp) {
					int half = size / 2;
					
					result.append('(');
					compress(srcRow, srcCol, half);
					compress(srcRow, srcCol + half, half);
					compress(srcRow + half, srcCol, half);
					compress(srcRow + half, srcCol + half, half);
					result.append(')');
					
					return;
				}
			}
		}
		
		result.append(comp);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		for(int i = 0; i < N; i++) video[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt).toArray();
		
		compress(0, 0, N);
		System.out.print(result);
	}
}