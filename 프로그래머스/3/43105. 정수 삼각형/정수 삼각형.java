import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        final int N = triangle.length;
        int[][] dp = new int[N + 1][N + 1];
        
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++) {
                dp[row][col] = triangle[row - 1][col - 1] + 
                    Math.max(dp[row - 1][col], dp[row - 1][col - 1]);
            }
        }
        
        return Arrays.stream(dp[N]).max().orElse(0);
    }
}