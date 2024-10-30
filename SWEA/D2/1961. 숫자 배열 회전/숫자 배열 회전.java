import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	private static final int COUNT = 4;
	
	private static int[][] rotate(int N, int[][] matrix) {
		int[][] rotated = new int[N][N];
		
		for(int i = 0; i < rotated.length; i++) {
			for(int j = 0; j < rotated.length;j++) rotated[i][j] = matrix[N - 1 - j][i];
		}
		
		return rotated;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
        	final int N = Integer.parseInt(br.readLine());
        	int[][][] matrix = new int[COUNT][N][N];
        	
        	for(int row = 0; row < N; row++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		for(int col = 0; col < N; col++) matrix[0][row][col] = Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i = 1; i < COUNT; i++) matrix[i] = rotate(N, matrix[i - 1]);
        	
        	result.append('#').append(tc).append('\n');
        	for(int row = 0; row < N; row++) {
        		for(int cnt = 1; cnt < COUNT; cnt++) {
        			for(int col = 0; col < N; col++) result.append(matrix[cnt][row][col]);
            		result.append(' ');
        		}
        		
        		result.append('\n');
        	}
        }
         
        System.out.print(result);
    }
}