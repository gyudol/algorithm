import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static final int T = 10;
	static final int N = 100;
	
	static char[][] board = new char[N][N];
	
	static boolean isPalindrome(StringBuilder str) {
		return str.toString().equals(str.reverse().toString());
	}
	
	static int getMaxLengthOfPalindrome() {
		int max = 1;

		for (int len = N; len > max; len--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - len; j++) {
					StringBuilder rowStr = new StringBuilder(),
							colStr = new StringBuilder();
					
					for (int k = j; k < j + len; k++) {
						rowStr.append(board[i][k]);
						colStr.append(board[k][i]);
					}
					
					if (isPalindrome(rowStr) || isPalindrome(colStr)) return len;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			final int TEST_CASE = Integer.parseInt(br.readLine());
			
			for (int row = 0; row < N; row++) {
				board[row] = br.readLine().toCharArray();
			}
			
			result.append('#').append(TEST_CASE).append(' ')
				.append(getMaxLengthOfPalindrome()).append('\n');
		}
		
		System.out.print(result);
	}
}