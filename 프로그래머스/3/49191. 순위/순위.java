class Solution {
    int countBackward(int des, boolean[] isVisited, boolean[][] graph) {
        int cnt = 1;
        
        for (int src = 1; src < isVisited.length; src++) {
            if (!graph[src][des] || isVisited[src]) continue;
            
            isVisited[src] = true;
            cnt += countBackward(src, isVisited, graph);
        }
        
        return cnt;
    }
    
    int countForward(int src, boolean[] isVisited, boolean[][] graph) {
        int cnt = 1;
        
        for (int des = 1; des < isVisited.length; des++) {
            if (!graph[src][des] || isVisited[des]) continue;
            
            isVisited[des] = true;
            cnt += countForward(des, isVisited, graph);
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        
        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (countForward(i, new boolean[n + 1], graph) + 
                countBackward(i, new boolean[n + 1], graph) - 1 == n) cnt++;
        }
        
        return cnt;
    }
}