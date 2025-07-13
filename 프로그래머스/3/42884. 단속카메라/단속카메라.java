import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));
        
        int last = routes[0][1], cameras = 1;
        
        for (int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            
            if (last >= route[0] && last <= route[1]) continue;
            last = route[1];
            cameras++;
        }
        
        return cameras;
    }
}