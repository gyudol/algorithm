import java.util.Stack;

class Solution {
    boolean isCorrect(int offset, String s) {
        Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt((i + offset) % s.length());
                
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (stack.empty() || (c == ')' && stack.peek() != '(') ||
                          (c == '}' && stack.peek() != '{') || 
                           (c == ']' && stack.peek() != '[')) {
                    
                    return false;
                } else {
                    stack.pop();
                }
            }
        
        return stack.empty();
    }
    
    public int solution(String s) {
        int cnt = 0;
        
        for (int offset = 0; offset < s.length(); offset++) {
            if (isCorrect(offset, s)) cnt++;
        }
        
        return cnt;
    }
}