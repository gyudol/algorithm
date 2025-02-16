class Solution {
    private static int N;
    private static int cnt = 0;
    
    private boolean isPromising(int col, int depth, int[] isVisited) {
        for(int row = 0; row < depth; row++) {
            if(isVisited[row] == col) return false;
            if(depth - row == Math.abs(isVisited[row] - col)) return false;
        }
        
        return true;
    }
    
    private void nQueen(int depth, int[] isVisited) {
        if(depth == N) {
            cnt++;
            return;
        }
        
        for(int col = 0; col < N; col++) {
            if(!isPromising(col, depth, isVisited)) continue;
            
            isVisited[depth] = col;
            nQueen(depth + 1, isVisited);
        }
    }
    
    public int solution(int n) {
        N = n;
        
        nQueen(0, new int[n]);
        return cnt;
    }
}