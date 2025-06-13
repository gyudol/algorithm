import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> idxStack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!idxStack.isEmpty() && prices[idxStack.peek()] > prices[i]) {
                int prevIdx = idxStack.pop();
                answer[prevIdx] = i - prevIdx;
            }
            
            idxStack.push(i);
        }
        
        while (!idxStack.isEmpty()) {
            int prevIdx = idxStack.pop();
            answer[prevIdx] = prices.length - 1 - prevIdx;
        }
        
        return answer;
    }
}