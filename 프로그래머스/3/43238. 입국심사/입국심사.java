class Solution {
    boolean isValid(int n, int[] times, long expectedTime) {
        long sum = 0;
        
        for (int time : times) {
            sum += expectedTime / time;
        }
        
        return sum >= n;
    }
    
    public long solution(int n, int[] times) {
        long start = 1,
            end = 1_000_000_000L * 1_000_000_000;
        
        while (end > start) {
            long mid = (start + end) / 2;
            
            if (isValid(n, times, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
}