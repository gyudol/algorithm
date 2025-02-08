import java.util.Set;
import java.util.HashSet;

class Solution {
    private static Set<Integer> sumSet = new HashSet<>();
    
    private void dfs(int src, int depth, int sum, int[] numbers) {
        if(depth == 2) {
            sumSet.add(sum);
            return;
        }
        
        for(int idx = src; idx < numbers.length; idx++) 
            dfs(idx + 1, depth + 1, sum + numbers[idx], numbers);
    }
    
    public int[] solution(int[] numbers) {
        dfs(0, 0, 0, numbers);
        
        return sumSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}