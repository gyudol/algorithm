import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
class Solution {
    static final List<String> DIR = Arrays.asList("left", "down", "right", "up");
     
    static void press(int N, int[][] board) {
        for (int row = 0; row < N; row++) {
            int pos = 0;
             
            for (int col = 1; col < N; col++) {
                if (board[row][col] == 0) continue;
                 
                if (board[row][pos] == 0) board[row][pos] = board[row][col];
                else if (board[row][pos] == board[row][col]) {
                	board[row][pos++] += board[row][col];
                	board[row][col] = 0;
                	continue;
                }
                else board[row][++pos] = board[row][col];
                
                if (pos != col) board[row][col] = 0;
            }
        }
    }
 
    static int[][] rotate(int cnt, int N, int[][] board) {  // clockwise
        for (int i = 0; i < cnt; i++) {
            int[][] rotated = new int[N][N];
             
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) 
                    rotated[row][col] = board[N - 1 - col][row];
            }
             
            board = rotated;
        }
         
        return board;
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
 
            board = rotate(M, N, board);
            press(N, board);
            board = rotate((DIR.size() - M) % DIR.size(), N, board);
             
            result.append('#').append(tc).append('\n');
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) result.append(board[row][col]).append(' ');
                result.append('\n');
            }
        }
         
        System.out.print(result);
    }
}