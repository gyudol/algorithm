import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n];
        
        for(int l : lost) clothes[l - 1]--;
        for(int r : reserve) clothes[r - 1]++;
        
        for(int idx = 0; idx < n; idx++) {
            if(clothes[idx] == -1) {
                if(idx > 0 && clothes[idx - 1] > 0) clothes[idx - 1]--;
                else if(idx < n - 1 && clothes[idx + 1] > 0) clothes[idx + 1]--;
                else continue;
                
                clothes[idx]++;
            }
        }
        
        return (int) Arrays.stream(clothes)
            .filter(cloth -> cloth >= 0)
            .count();
    }
}