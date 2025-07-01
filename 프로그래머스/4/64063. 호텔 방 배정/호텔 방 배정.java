import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Long, Long> terminal;
    
    long root(long node) {
        if (!terminal.containsKey(node)) return node;
        
        long root = root(terminal.get(node));
        
        terminal.put(node, root);
        return root;
    }
    
    public long[] solution(long k, long[] room_number) {
        terminal = new HashMap<>();
        long[] selected = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];
            
            if (terminal.containsKey(room)) {
                room = selected[i] = root(room);
            } else {
                selected[i] = room;
            }
            
            terminal.put(room, root(room + 1));
        }
        
        return selected;
    }
}