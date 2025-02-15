import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(stack.isEmpty() || stack.pop() != '(') return false;
        }

        return stack.isEmpty();
    }
}