import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));
        
        int lastPos = routes[0][1], cameras = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (lastPos >= routes[i][0]) continue;
            
            lastPos = routes[i][1];
            cameras++;
        }
        
        return cameras;
    }
}