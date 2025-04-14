class Solution {
	static final int M = 10;
    static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static final int[][] COLLISIONS = {null, {2, 0, 3, 1},
            {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 3, 0, 1}};
    
    static int N;
    static int[][] board;
    static int[][] wormholes;
    
    static int playPinball(int srcRow, int srcCol, int d) {
        int score = 0, row = srcRow, col = srcCol;
        
        while (true) {
            row += DIR[d][0];
            col += DIR[d][1];
            int block;
            
            if (row < 0 || row >= N || col < 0 || col >= N) return score * 2 + 1;
            		
            if ((row == srcRow && col == srcCol) || (block = board[row][col]) == -1) break;
            else if (block > 0 && block <= 5) {
                d = COLLISIONS[block][d];
            	score++;
            }
            else if (block > 5) {
                if (wormholes[block][0] == row * N + col) {
                    row = wormholes[block][1] / N;
                    col = wormholes[block][1] % N;
                }
                else {
                    row = wormholes[block][0] / N;
                    col = wormholes[block][0] % N;
                }
            }
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
            wormholes = new int[M + 1][2];
            
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int block = board[row][col] = readInt();
                    
                    if (block >= 6) {
                        if (wormholes[block][0] == 0) wormholes[block][0] = row * N + col;
                        else wormholes[block][1] = row * N + col;
                    }
                }
            }

            result.append('#').append(tc).append(' ').append(getMaxScore()).append('\n');
        }
         
        System.out.print(result);
    }
}