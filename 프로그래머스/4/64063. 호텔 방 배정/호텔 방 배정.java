import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Long, Long> terminal;
    
    long root(long node) {
        if (!terminal.containsKey(node)) {
            terminal.put(node, node + 1);
            return node;
        }
        
        long root = root(terminal.get(node));
        
        terminal.put(node, root);
        return root;
    }
    
    public long[] solution(long k, long[] room_number) {
        terminal = new HashMap<>();
        long[] selected = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            selected[i] = root(room_number[i]);
        }
        
        return selected;
    }
}