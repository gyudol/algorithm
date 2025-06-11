import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static final int T = 10;
	static final int N = 8;
	
	static boolean isPalindrome(StringBuilder str) {
		return str.toString().equals(str.reverse().toString());
	}
	
	static int getPalindromeCount(int M, char[][] board) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				StringBuilder rowStr = new StringBuilder(),
						colStr = new StringBuilder();
				
				 for (int k = j; k < j + M; k++) {
					rowStr.append(board[i][k]);
					colStr.append(board[k][i]);
				}
				
				if (isPalindrome(rowStr)) cnt++;
				if (isPalindrome(colStr)) cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			final int M = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			result.append('#').append(tc).append(' ')
				.append(getPalindromeCount(M, board)).append('\n');
		}
		
		System.out.print(result);
	}
}