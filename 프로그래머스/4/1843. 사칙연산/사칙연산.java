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
        if (dp[start][end][compType] != INITIAL_VALUES[compType]) {
            return dp[start][end][compType];
        }
        if (end - start == 1) {
            return dp[start][end][compType] = Integer.parseInt(arr[start]);
        }
        
        int result = INITIAL_VALUES[compType];
        
        for (int i = start + 1; i < end; i += 2) {
            int left = compute(start, i, compType, arr);
            int right = arr[i].equals("+") 
                ? compute(i + 1, end, compType, arr)
                : compute(i + 1, end, 1 - compType, arr);
            
            int value = arr[i].equals("+") ? left + right : left - right;
            
            if (COMPARATORS.get(compType).compare(value, result) > 0) {
                result = value;
            }
        }
        
        return dp[start][end][compType] = result;
    }
    
    public int solution(String arr[]) {
        dp = new int[arr.length][arr.length + 1][2];
        
        for (int src = 0; src < arr.length; src++) {
            for (int des = 0; des <= arr.length; des++) {
                dp[src][des][0] = INITIAL_VALUES[0];
                dp[src][des][1] = INITIAL_VALUES[1];
            }
        }
        
        return compute(0, arr.length, 0, arr);
    }
}