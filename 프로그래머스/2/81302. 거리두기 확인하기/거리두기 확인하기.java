class Solution {
    final int N = 5;
    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    boolean isInBounds(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
    
    boolean isNextToVolunteer(char[][] room, int row, int col, int except) {
        for (int d = 0; d < DIRECTIONS.length; d++) {
            if (d == except) continue;
            
            int nr = row + DIRECTIONS[d][0], nc = col + DIRECTIONS[d][1];
            
            if (isInBounds(nr, nc) && room[nr][nc] == 'P') return true;
        }
        
        return false;
    }
    
    boolean isDistanced(char[][] room, int row, int col) {
        for (int d = 0; d < DIRECTIONS.length; d++) {
            int nr = row + DIRECTIONS[d][0], nc = col + DIRECTIONS[d][1];
            
            if (!isInBounds(nr, nc)) continue;
            
            switch (room[nr][nc]) {
                case 'P': return false;
                case 'O': if (isNextToVolunteer(room, nr, nc, 3 - d)) return false;
            }
        }
        
        return true;
    }
    
    int isSafeRoom(char[][] room) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (room[row][col] == 'P' && !isDistanced(room, row, col)) return 0;
            }
        }
        
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] checked = new int[N];
        
        for (int i = 0; i < N; i++) {
            char[][] room = new char[N][N];
            
            for (int j = 0; j < N; j++) {
                room[j] = places[i][j].toCharArray();
            }
            
            checked[i] = isSafeRoom(room);
        }
        
        return checked;
    }
}