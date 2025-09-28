class Solution {
	static final int N = 10;
	static final int[][] DIRECTIONS = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static Coord A, B;
	static Charger[] chargers;
	
	static int getMaxChargeAmount() {
		int max = 0;
		
		for (int i = 0; i < chargers.length; i++) {
			for (int j = 0; j < chargers.length; j++) {
				int chargeA = chargers[i].isInRange(A.row, A.col) ? chargers[i].perf : 0,
						chargeB = chargers[j].isInRange(B.row, B.col) ? chargers[j].perf : 0;
				
				int total = (i == j && chargeA > 0 && chargeB > 0) ? chargeA : chargeA + chargeB;
				
				max = Math.max(total, max);
			}
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
    	
    	boolean isInRange(int row, int col) {
    		return coverage >= 
    				Math.abs(row - this.row) + Math.abs(col - this.col);
    	}
    }
}