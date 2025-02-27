class Solution {
    private static final int MOD = 1234567;
    
    public int solution(int n) {
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            if(i <= 1) dp[i] = i;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        return dp[n];
    }
}