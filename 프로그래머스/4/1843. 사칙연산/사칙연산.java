import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    final List<Comparator<Integer>> COMPARATORS = Arrays.asList(
        (a, b) -> Integer.compare(a, b),
        (a, b) -> Integer.compare(b, a)
    );
    
    final int[] INITIAL_VALUES = {
        Integer.MIN_VALUE,
        Integer.MAX_VALUE
    };
    
    int[][][] dp;
    
    int compute(int start, int end, int compType, String[] arr) {
        if (dp[compType][start][end] != INITIAL_VALUES[compType])
            return dp[compType][start][end];
        if (end - start == 1) return dp[compType][start][end]
                = Integer.parseInt(arr[start]);
        
        int result = INITIAL_VALUES[compType];
        
        for (int i = start + 1; i < end; i += 2) {
            int left = compute(start, i, compType, arr),
                right = arr[i].equals("+") 
                    ? compute(i + 1, end, compType, arr)
                    : compute(i + 1, end, 1 - compType, arr);
            
            int value = arr[i].equals("+") ? left + right : left - right;
            
            if (COMPARATORS.get(compType).compare(value, result) > 0) {
                result = value;
            }
        }
        
        return dp[compType][start][end] = result;
    }
    
    public int solution(String arr[]) {
        dp = new int[2][arr.length][arr.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[0][i], Integer.MIN_VALUE);
            Arrays.fill(dp[1][i], Integer.MAX_VALUE);
        }
        
        return compute(0, arr.length, 0, arr);
    }
}