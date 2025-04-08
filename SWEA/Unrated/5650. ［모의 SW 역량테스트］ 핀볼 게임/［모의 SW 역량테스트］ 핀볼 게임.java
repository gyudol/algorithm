import java.util.HashMap;
import java.util.Map;

class Solution {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
	
	static class Coord {
		int row, col;
		
		Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int hashCode() {
			return Integer.hashCode(row*N+col);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Coord)) return false;
			
			Coord o = (Coord) obj;
			return row == o.row && col == o.col;
		}
	}
	
	static int N;
	static int[][] board;
	static Map<Coord, Coord> wormholes;
	
	static int collide(int block, int curDir) {
		switch (block) {
			case 1: {
				if (curDir == 1) return 0;	// 하 -> 우
				if (curDir == 2) return 3;	// 좌 -> 상
				break;
			}
			case 2: {
				if (curDir == 2) return 1;	// 좌 -> 하
				if (curDir == 3) return 0;	// 상 -> 우
				break;
			}
			case 3: {
				if (curDir == 0) return 1;	// 우 -> 하
				if (curDir == 3) return 2;	// 상 -> 좌
				break;
			}
			case 4: {
				if (curDir == 0) return 3;	// 우 -> 상
				if (curDir == 1) return 2;	// 하 -> 좌
			}
		}
		
		// else case opposite
		return (curDir + 2) % DIR.length;
	}
	
	static int playPinball(int srcRow, int srcCol, int d) {
		int score = 0, row = srcRow, col = srcCol;
		
		while (true) {
			int nextRow = row + DIR[d][0], nextCol = col + DIR[d][1];
			
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
				row = nextRow;
				col = nextCol;
				d = (d + 2) % DIR.length;
				score++;
				continue;	// keep pos
			}	// wall case
			
			int block = board[nextRow][nextCol];
			
			if ((nextRow == srcRow && nextCol == srcCol) || block == -1) break;
			else if (block >= 1 && block <= 5) {	// block case
				d = collide(block, d);
				score++;
			}
			else if (block >= 6 && block <= 10) {	// wormhole case
				Coord des = wormholes.get(new Coord(nextRow, nextCol));
				nextRow = des.row;
				nextCol = des.col;
			}
			
			row = nextRow;
			col = nextCol;
		}
		
		return score;
	}
	
	static int getMaxScore() {
		int max = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[row][col] != 0) continue;
				
				for (int d = 0; d < DIR.length; d++) 
					max = Math.max(playPinball(row, col, d), max);
			}
		}
		
		return max;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		boolean isNegative = c == 45;
		
		if (isNegative) c = System.in.read();
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return isNegative ?  ~n + 1 : n;
	}
	
    public static void main(String[] args) throws Exception {
        final int T = readInt();
        StringBuilder result = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
        	N = readInt();
        	board = new int[N][N];
        	wormholes = new HashMap<>();
        	Coord[] isVisited = new Coord[11];
        	
        	for (int row = 0; row < N; row++) {
        		for (int col = 0; col < N; col++) {
        			int block = board[row][col] = readInt();
        			
        			if (block >= 6 && block <= 10) {
        				if (isVisited[block] != null) {
        					Coord wormhole = new Coord(row, col);
        					
        					wormholes.put(isVisited[block], wormhole);
        					wormholes.put(wormhole, isVisited[block]);
        					continue;
        				}
        				
        				isVisited[block] = new Coord(row, col);
        			}
        		}
        	}
        	
        	result.append('#').append(tc).append(' ').append(getMaxScore()).append('\n');
        }
         
        System.out.print(result);
    }
}