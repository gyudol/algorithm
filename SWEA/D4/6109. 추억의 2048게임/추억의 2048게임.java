import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static final int D = 4;
	static final List<String> DIR = Arrays.asList("left", "down", "right", "up");
	
	static void press(int N, int[][] board) {
		for (int row = 0; row < N; row++) {
			for(int srcCol = 0, desCol = 1; srcCol < N - 1; desCol = ++srcCol + 1) {
				while (desCol < N && board[row][srcCol] == 0) {
					board[row][srcCol] += board[row][desCol];
					board[row][desCol++] = 0;
				}
				
				while (desCol < N && board[row][desCol] == 0) desCol++;
				
				if (desCol < N && board[row][srcCol] == board[row][desCol]) {
					board[row][srcCol] += board[row][desCol];
					board[row][desCol] = 0;
				}
			}
		}
	}
	
	static int[][] rotate(int N, int[][] board) {	// clockwise
		int[][] rotated = new int[N][N];
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) 
				rotated[row][col] = board[N - 1 - col][row];
		}
		
		return rotated;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	final int N = Integer.parseInt(st.nextToken());
        	final String S = st.nextToken();
        	int[][] board = new int[N][N];
        	
        	for (int row = 0; row < N; row++) {
        		st = new StringTokenizer(br.readLine());
        		
        		for (int col = 0; col < N; col++) 
        			board[row][col] = Integer.parseInt(st.nextToken());
        	}
        	
        	final int M = DIR.indexOf(S);
        	
        	for (int i = 1; i <= M; i++) board = rotate(N, board);
        	press(N, board);
        	for (int i = 1; i <= D - M; i++) board = rotate(N, board);
        	
        	result.append('#').append(tc).append('\n');
        	for (int row = 0; row < N; row++) {
        		for (int col = 0; col < N; col++) result.append(board[row][col]).append(' ');
        		result.append('\n');
        	}
        }
        
        System.out.print(result);
    }
}