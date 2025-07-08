import java.util.Arrays;

class Solution {
    boolean isValid(int n, int[] rocks, int minDistance) {
        int deleted = 0, prev = 0;
        
        for (int rock : rocks) {
            if (rock - prev < minDistance) {
                deleted++;
            } else {
                prev = rock;
            }
        }
        
        return deleted <= n;
    }
    
    int binarySearch(int n, int[] rocks) {
        int start = 0,
            end = rocks[rocks.length - 1] + 1;
        
        while (end - start > 1) {
            int mid = (start + end) / 2;
            
            if (isValid(n, rocks, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        
        return binarySearch(n, rocks);
    }
}