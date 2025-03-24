class Solution {
    final int MAX = 100_000;
    int[] fib = new int[MAX + 1];
    
    public int solution(int n) {
        if (n <= 1) return n;
        if (fib[n] != 0) return fib[n];
        
        return fib[n] = (solution(n - 1) + solution(n - 2)) % 1234567;
    }
}