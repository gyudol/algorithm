class Solution {
    final int N = 5;
    final int MAX_DISTANCE = 2;
    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    boolean isSafeDistance(int row, int col, int depth, char[][] room, boolean[][] isVisited) {
        if (room[row][col] == 'P' && depth > 0) return false;
        if (depth == MAX_DISTANCE) return true;
        
        for (int[] d : DIRECTIONS) {
            int nr = row + d[0], nc = col + d[1];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= N ||
                room[nr][nc] == 'X' || isVisited[nr][nc]) continue;
            
            isVisited[row][col] = true;
            if (!isSafeDistance(nr, nc, depth + 1, room, isVisited)) return false;
        }
        
        return true;
    }
    
    int checkRoomCompliance(String[] place) {
        char[][] room = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            room[i] = place[i].toCharArray();
        }
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (room[row][col] == 'P' &&
                    !isSafeDistance(row, col, 0, room, new boolean[N][N])) return 0;
            }
        }
        
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] checks = new int[N];
        
        for (int i = 0; i < N; i++) {
            checks[i] = checkRoomCompliance(places[i]);
        }
        
        return checks;
    }
}