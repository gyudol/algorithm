import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        while (k-- > 0) {
            stack.pop();
        }
        
        return stack.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}