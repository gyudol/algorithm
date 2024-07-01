import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 8;
	private static final String [] WB_BOARD = {"WBWBWBWB", "BWBWBWBW"};
	private static String [] board;
	
	private static int getMinCost(int srcRow, int srcCol) {
		int WB_cnt = 0;
		
		for(int i = 0; i < LEN; i++) {
			for(int j = 0; j < LEN; j++) {
				if(board[i + srcRow].charAt(j + srcCol) != WB_BOARD[i % WB_BOARD.length].charAt(j)) 
					WB_cnt++;
			}
		}
		
		// BW_cnt = 64 - WB_cnt (체스판의 최대 크기가 8*8이기 때문)
		return Math.min(WB_cnt, LEN * LEN - WB_cnt);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		board = new String [n];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) board[i] = br.readLine();
		
		for(int i = 0; i <= n - LEN; i++) {
			for(int j = 0; j <= m - LEN; j++) {
				min = Math.min(min, getMinCost(i, j));
			}
		}
		
		System.out.print(min);
	}
}