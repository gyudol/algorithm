import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    int R, C;
    char[][] maze;
    
    Coord getCoordinate(char point) {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (maze[row][col] == point) return new Coord(row, col);
            }
        }
        
        return null;
    }
    
    int bfs(char src, char des) {
        Coord start = getCoordinate(src);
        boolean[][] isVisited = new boolean[R][C];
        Queue<State> q = new ArrayDeque<>();
        
        q.offer(new State(start.row, start.col, 0));
        isVisited[start.row][start.col] = true;
        
        while (!q.isEmpty()) {
            State state = q.poll();
            int row = state.row, col = state.col, time = state.time;
            
            if (maze[row][col] == des) return time;
            
            for (int[] d : DIRECTIONS) {
                int nr = row + d[0], nc = col + d[1];
                
                if (nr < 0 || nr >= R || nc < 0 || nc >= C || 
                    maze[nr][nc] == 'X' || isVisited[nr][nc]) continue;
                
                isVisited[nr][nc] = true;
                q.offer(new State(nr, nc, time + 1));
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        maze = new char[R][];
        
        for (int i = 0; i < R; i++) {
            maze[i] = maps[i].toCharArray();
        }
        
        int timeToLever = bfs('S', 'L'),
            timeToExit = bfs('L', 'E');
        
        if (timeToLever == -1 || timeToExit == -1) return -1;
        return timeToLever + timeToExit;
    }
    
    class Coord {
        int row, col;
        
        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    class State extends Coord {
        int time;
        
        State(int row, int col, int time) {
            super(row, col);
            this.time = time;
        }
    }
}