import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String before, String after) {
        List<Character> list = new ArrayList<>();
        
        for(char c : before.toCharArray()) list.add(c);
        for(char c : after.toCharArray()) {
            if(!list.remove((Character) c)) return 0;
        }
        
        return 1;
    }
}