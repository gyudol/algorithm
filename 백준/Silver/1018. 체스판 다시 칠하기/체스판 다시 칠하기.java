import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 8;
	private static final char [] COLOR = {'B', 'W'};
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		char [][] WB_board = new char [COLOR.length][LEN];	// 2줄씩 반복되는 구조
		char [][] BW_board = new char [COLOR.length][LEN];
		char [][] board = new char [n][m];
		int srcRow = 0, desRow = LEN, srcCol = 0, desCol = LEN;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < m; j++) board[i][j] = line.charAt(j);
		}
		
		for(int i = 0; i < COLOR.length; i++) {
			for(int j = 0; j < LEN; j++) {
				int colorIdx = j % COLOR.length;
				
				WB_board[i][j] = i == 0 ? COLOR[1 - colorIdx] : COLOR[colorIdx];
				BW_board[i][j] = i == 0 ? COLOR[colorIdx] : COLOR[1 - colorIdx];
			}
		}
		
		while(desRow <= n) {
			int wbCnt = 0, bwCnt = 0;
			
			for(int i = srcRow; i < desRow; i++) {
				for(int j = srcCol; j < desCol; j++) {
					if(board[i][j] != WB_board[i % COLOR.length][j - srcCol]) wbCnt++;
					if(board[i][j] != BW_board[i % COLOR.length][j - srcCol]) bwCnt++;
				}
			}
			
			min = Math.min(Math.min(min, wbCnt), bwCnt);
			srcCol++;	desCol++;
			
			if(desCol > m) {
				srcRow++;	desRow++;
				srcCol = 0;	desCol = LEN;
			}
		}
		
		System.out.print(min);
	}
}