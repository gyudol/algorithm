import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static final int LEN = 9;
	private static final int OFFSET = 3;
	
	private static int isPromising(int[][] sudoku) {
		Set<Integer> set = new HashSet<>();
		
		for(int row = 0; row < LEN; row++) {
			for(int col = 0; col < LEN; col++) set.add(sudoku[row][col]);
			
			if(set.size() != LEN) return 0;
			set.clear();
		}
		
		for(int col = 0; col < LEN; col++) {
			for(int row = 0; row < LEN; row++) set.add(sudoku[row][col]);

			if(set.size() != LEN) return 0;
			set.clear();
		}
		
		int srcRow = 0, srcCol = 0;
		
		while(srcRow < LEN && srcCol < LEN) {
			for(int row = srcRow; row < srcRow + OFFSET; row++) {
				for(int col = srcCol; col < srcCol + OFFSET; col++) set.add(sudoku[row][col]);
			}
			
			if(set.size() != LEN) return 0;
			set.clear();
			
			srcCol += OFFSET;
			if(srcCol >= LEN) {
				srcRow += OFFSET;
				srcCol = 0;
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[LEN][LEN];
			
			for(int row = 0; row < LEN; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < LEN; col++) sudoku[row][col] = Integer.parseInt(st.nextToken());
			}
			
			result.append('#').append(tc).append(' ').append(isPromising(sudoku)).append('\n');
		}
		
		System.out.print(result);
	}
}