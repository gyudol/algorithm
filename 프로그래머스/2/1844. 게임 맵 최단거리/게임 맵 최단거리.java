import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private class State {
        int row;
        int col;
        int dist;
        
        private State(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        final int tgRow = maps.length - 1, tgCol = maps[0].length - 1;
        Queue<State> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[tgRow + 1][tgCol + 1];
        
        isVisited[0][0] = true;
        q.offer(new State(0, 0, 1));
        
        while(!q.isEmpty()) {
            State state = q.poll();
            int row = state.row, col = state.col, dist = state.dist;
            
            if(row == tgRow && col == tgCol) return dist;
            
            for(int[] d : DIR) {
                int nextRow = row + d[0], nextCol = col + d[1];
                
                if(nextRow < 0 || nextRow > tgRow || nextCol < 0 || nextCol > tgCol
                    || isVisited[nextRow][nextCol] || maps[nextRow][nextCol] == 0) continue;
                
                isVisited[nextRow][nextCol] = true;
                q.offer(new State(nextRow, nextCol, dist + 1));
            }
        }
        
        return -1;
    }
}