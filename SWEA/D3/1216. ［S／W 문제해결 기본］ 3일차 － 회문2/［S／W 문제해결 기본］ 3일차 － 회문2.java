import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static final int T = 10;
	static final int N = 100;
	static final int MIN_PALINDROME_LENGTH = 1;
	
	static char[][] board = new char[N][N];
	
	static boolean isPalindromeRow(int len, int i, int src) {
		int des = src + len - 1;
		
		for (int j = 0; j < len / 2; j++) {
			if (board[i][src + j] != board[i][des - j]) return false;
		}
		
		return true;
	}
	
	static boolean isPalindromeCol(int len, int i, int src) {
		int des = src + len - 1;
		
		for (int j = 0; j < len / 2; j++) {
			if (board[src + j][i] != board[des - j][i]) return false;
		}
		
		return true;
	}
	
	static int getMaxLengthOfPalindrome() {
		for (int len = N; len > MIN_PALINDROME_LENGTH; len--) {
			for (int i = 0; i < N; i++) {
				for (int src = 0; src <= N - len; src++) {
					if (isPalindromeRow(len, i, src)
							|| isPalindromeCol(len, i, src)) return len;
				}
			}
		}
		
		return MIN_PALINDROME_LENGTH;
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