import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 9;
	private static int [][] board;
	private static int blankCnt;
	private static List<int []> blankList;
	private static boolean flag;
	
	private static boolean isValid(int r, int c, int value) {
		for(int col = 0; col < LEN; col++) {
			if(board[r][col] == value) return false;
		}
		
		for(int row = 0; row < LEN; row++) {
			if(board[row][c] == value) return false;
		}
		
		int rowSrc = r / 3 * 3, colSrc = c / 3 * 3;
		int rowDes = rowSrc + 2, colDes = colSrc + 2;
		
		for(int row = rowSrc; row <= rowDes; row++) {
			for(int col = colSrc; col <= colDes; col++) {
				if(board[row][col] == value) return false;
			}
		}
		
		return true;
	}
	
	private static void makeSdoku(int depth) {
		if(depth == blankCnt) {
			flag = true;
			return;
		}
		
		int [] coord = blankList.get(depth);
		
		for(int i = 1; i <= LEN; i++) {
			if(!isValid(coord[0], coord[1], i)) continue;
			
			board[coord[0]][coord[1]] = i;
			makeSdoku(depth + 1);
			if(flag) return;
			board[coord[0]][coord[1]] = 0;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		board = new int [LEN][LEN];
		blankCnt = 0;
		blankList = new ArrayList<>();
		flag = false;
		
		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < LEN; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == 0) {
					blankList.add(new int [] {i, j});
					blankCnt++;
				}
			}
		}
		
		makeSdoku(0);
		
		for(int i = 0; i < LEN; i++) {
			for(int j = 0; j < LEN; j++) result.append(board[i][j]).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}