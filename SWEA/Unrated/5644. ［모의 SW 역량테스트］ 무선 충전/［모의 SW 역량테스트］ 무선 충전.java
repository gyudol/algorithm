class Solution {
	static final int N = 10;
	static final int[][] DIRECTIONS = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static Coord A, B;
	static Charger[] chargers;
	static int[][] board;
	
	static int getChargeAmount(Coord coord, int excluded) {
		int max = 0;
		
		for (int i = 0; i < chargers.length; i++) {
			if (i != excluded && (board[coord.row][coord.col] & 1 << i) != 0) {
				max = Math.max(chargers[i].perf, max);
			}
		}
		
		return max;
	}
	
	static int getMaxChargeAmount() {
		int max = 0;
		
		if (board[A.row][A.col] > 0 && board[B.row][B.col] > 0) {
			for (int i = 0; i < chargers.length; i++) {
				if ((board[A.row][A.col] & 1 << i) != 0) {
					max = Math.max(chargers[i].perf + getChargeAmount(B, i), max);
				}
			}
		} else if (board[A.row][A.col] > 0) {
			max = getChargeAmount(A, -1);
		} else {
			max = getChargeAmount(B, -1);
		}
		
		return max;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
    public static void main(String[] arge) throws Exception {
    	final int T = readInt();
    	StringBuilder result = new StringBuilder();
    	
    	for (int tc = 1; tc <= T; tc++) {
    		A = new Coord(1, 1);
    		B = new Coord(10, 10);
    		final int M = readInt(), K = readInt();
    		int[][] moves = new int[2][M];
    		
    		for (int i = 0; i < moves.length; i++) {
    			for (int j = 0; j < M; j++) {
    				moves[i][j] = readInt();
    			}
    		}
    		
    		chargers = new Charger[K];
    		
    		for (int i = 0; i < K; i++) {
    			chargers[i] = new Charger(readInt(), readInt(), readInt(), readInt());
    		}
    		
    		board = new int[N + 1][N + 1];
    		
    		for (int row = 1; row <= N; row++) {
    			for (int col = 1; col <= N; col++) {
    				for (int i = 0; i < K; i++) {
    					int dist = Math.abs(chargers[i].row - row) + 
    							Math.abs(chargers[i].col - col);
    					
    					if (dist <= chargers[i].coverage) {
    						board[row][col] |= 1 << i;
    					}
    				}
    			}
    		}
    		
    		int power = getMaxChargeAmount();
    		
    		for (int i = 0; i < M; i++) {
    			A.move(moves[0][i]);
    			B.move(moves[1][i]);
    			
    			power += getMaxChargeAmount();
    		}
    		
    		result.append('#').append(tc).append(' ').append(power).append('\n');
    	}
    	
    	System.out.print(result);
    }
    
    static class Coord {
    	int col, row;
    	
    	Coord(int col, int row) {
    		this.col = col;
    		this.row = row;
    	}
    	
    	void move(int move) {
    		row += DIRECTIONS[move][0];
    		col += DIRECTIONS[move][1];
    	}
    }
    
    static class Charger extends Coord {
    	int coverage, perf;
    	
    	Charger(int col, int row, int coverage, int perf) {
    		super(col, row);
    		this.coverage = coverage;
    		this.perf = perf;
    	}
    }
}