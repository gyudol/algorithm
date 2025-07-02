import java.util.ArrayList;

class Solution {
    int dfs(int src, int depth, boolean[] isVisited, ArrayList<ArrayList<Integer>> matches) {
        if (isVisited[src]) return 0;
        
        isVisited[src] = true;
        int cnt = 1;
        
        for (int target : matches.get(src)) {
            cnt += dfs(target, depth + 1, isVisited, matches);
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> winMatches = new ArrayList<>();
        ArrayList<ArrayList<Integer>> loseMatches = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            winMatches.add(new ArrayList<>());
            loseMatches.add(new ArrayList<>());
        }
        for (int[] result : results) {
            winMatches.get(result[0]).add(result[1]);
            loseMatches.get(result[1]).add(result[0]);
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            int winCnt = dfs(i, 0, new boolean[n + 1], winMatches),
                loseCnt = dfs(i, 0, new boolean[n + 1], loseMatches);
            
            if (winCnt + loseCnt - 1 == n) cnt++;
        }
        
        return cnt;
    }
}