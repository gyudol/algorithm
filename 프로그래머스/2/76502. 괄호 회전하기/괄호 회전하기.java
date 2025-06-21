import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean isCorrect(int offset, char[] str) {
        Deque<Character> stack = new ArrayDeque<>();
            
            for (int i = 0; i < str.length; i++) {
                char c = str[(i + offset) % str.length];
                
                switch (c) {
                    case '(': stack.push(')'); break;
                    case '{': stack.push('}'); break;
                    case '[': stack.push(']'); break;
                    case ')': case '}': case ']':
                        if (stack.isEmpty() || c != stack.pop()) return false;
                }
            }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        char[] str = s.toCharArray();
        int cnt = 0;
        
        for (int offset = 0; offset < s.length(); offset++) {
            if (isCorrect(offset, str)) cnt++;
        }
        
        return cnt;
    }
}