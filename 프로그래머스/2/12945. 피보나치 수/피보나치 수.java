class Solution {
    final int MAX = 100_000;
    final int MOD = 1234567;
    
    public int solution(int n) {
        int[] fib = new int[MAX + 1];
        fib[1] = fib[2] = 1;
        
        for (int i = 3; i <= n; i++) 
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        
        return fib[n];
    }
}