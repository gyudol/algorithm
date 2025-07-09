class Solution {
    boolean dfs(int src, int[][] computers, boolean[] isVisited) {
        if (isVisited[src]) return false;
        isVisited[src] = true;
        
        for (int des = 0; des < computers.length; des++) {
            if (computers[src][des] == 0) continue;
            dfs(des, computers, isVisited);
        }
        
        return true;
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int network = 0;
        
        for (int i = 0; i < n; i++) {
            if (dfs(i, computers, isVisited)) network++;
        }
        
        return network;
    }
}