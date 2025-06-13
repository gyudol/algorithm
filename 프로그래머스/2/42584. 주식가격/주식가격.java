import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        int[] terms = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] > prices[i]) {
                int prevIdx = indexStack.pop();
                terms[prevIdx] = i - prevIdx;
            }
            
            indexStack.push(i);
        }
        
        while (!indexStack.isEmpty()) {
            int prevIdx = indexStack.pop();
            terms[prevIdx] = prices.length - 1 - prevIdx;
        }
        
        return terms;
    }
}