import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static final char[] GAZE = {'^', 'v', '<', '>'};
	static int H, W, N;
	static char[][] board;
	static int curRow, curCol;
	
	static int getGazeIdx(char c) {
		for(int i = 0; i < GAZE.length; i++) {
			if(c == GAZE[i]) return i;
		}
		
		return -1;
	}
	
	static void move(int d) {
		int nextRow = curRow + DIR[d][0], nextCol = curCol + DIR[d][1];

		board[curRow][curCol] = GAZE[d];
		if(nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W
				|| board[nextRow][nextCol] != '.') return;
		
		board[nextRow][nextCol] = board[curRow][curCol];
		board[curRow][curCol] = '.';
		curRow = nextRow;
		curCol = nextCol;
	}
	
	static void shoot(int d) {
		int nextRow = curRow, nextCol = curCol;
		
		while(true) {
			nextRow += DIR[d][0];	nextCol += DIR[d][1];
			
			if(nextRow < 0 || nextRow >= H || nextCol < 0 
					|| nextCol >= W || board[nextRow][nextCol] == '#') return;
			if(board[nextRow][nextCol] == '*') {
				board[nextRow][nextCol] = '.';
				return;
			}
		}
	}
	
	static void battleField(char[] orders) {
		for(char order : orders) {
			switch(order) {
				case 'U': move(0);	break;
				case 'D': move(1);	break;
				case 'L': move(2);	break;
				case 'R': move(3);	break;
				case 'S': shoot(getGazeIdx(board[curRow][curCol]));
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken());	W = Integer.parseInt(st.nextToken());
        	board = new char[H][W];
        	
        	for(int row = 0; row < H; row++) {
        		String line = br.readLine();
        		
        		for(int col = 0; col < W; col++) {
        			board[row][col] = line.charAt(col);
        			
        			if(getGazeIdx(board[row][col]) >= 0) {
        				curRow = row;
    					curCol = col;
        			}
        		}
        	}
        	
        	N = Integer.parseInt(br.readLine());
        	final char[] orders = br.readLine().toCharArray();
        	
        	battleField(orders);
        	result.append('#').append(tc).append(' ');
        	for(char[] row : board) {
        		for(char c : row) result.append(c);
        		result.append('\n');
        	}
        }
         
        System.out.print(result);
    }
}