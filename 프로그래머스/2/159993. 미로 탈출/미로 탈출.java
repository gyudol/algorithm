import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N, M;
    private static int srcRow, srcCol;
    
    private class State {
        int row, col, dist;
        
        private State(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    private int bfs(char[][] maze, char target) {
        Queue<State> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        
        q.offer(new State(srcRow, srcCol, 0));
        isVisited[srcRow][srcCol] = true;
        
        while(!q.isEmpty()) {
            State state = q.poll();
            int row = state.row, col = state.col, dist = state.dist;
            
            if(maze[row][col] == target) {
                srcRow = row;   srcCol = col;
                return dist;
            }
            
            for(int[] d : DIR) {
                int nextRow = row + d[0], nextCol = col + d[1];
                
                if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M
                    || isVisited[nextRow][nextCol] || maze[nextRow][nextCol] == 'X') continue;
                
                isVisited[nextRow][nextCol] = true;
                q.offer(new State(nextRow, nextCol, dist + 1));
            }
        }
        
        return -1;
    }
    
    private void getSource(char[][] maze) {
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                if(maze[row][col] == 'S') {
                    srcRow = row;   srcCol = col;
                    return;
                }
            }
        }
    }
    
    public int solution(String[] maps) {
        char[][] maze = new char[maps.length][];
        N = maps.length; M = maps[0].length();
        
        for(int idx = 0; idx < N; idx++) maze[idx] = maps[idx].toCharArray();
        getSource(maze);
        
        int levDist = bfs(maze, 'L');
        if(levDist == -1) return levDist;
        
        int resDist = bfs(maze, 'E');
        if(resDist == -1) return resDist;
        
        return levDist + resDist;
    }
}