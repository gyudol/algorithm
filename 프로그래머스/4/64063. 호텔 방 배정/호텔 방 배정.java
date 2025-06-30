import java.util.Map;
import java.util.HashMap;

class Solution {
    public long[] solution(long k, long[] room_number) {
        Map<Long, Room> hotel = new HashMap<>();
        long[] selected = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            long num = room_number[i];
            
            if (hotel.containsKey(num)) {
                num = hotel.get(num).root().next;
            }
            
            Room room = new Room(num);
            hotel.put(num, room);
            selected[i] = num;
            
            if (hotel.containsKey(num - 1)) room.merge(hotel.get(num - 1));
            if (hotel.containsKey(num + 1)) room.merge(hotel.get(num + 1));
        }
        
        return selected;
    }
    
    class Room {
        Room parent;
        long next;
        
        Room(long num) {
            this.parent = null;
            this.next = num + 1;
        }
        
        Room root() {
            if (parent == null) return this;
            return parent = parent.root();
        }
        
        void merge(Room v) {
            Room rootU = root(), rootV = v.root();
            
            if (rootU == rootV) return;
            rootV.parent = rootU;
            rootU.next = rootV.next = Math.max(rootU.next, rootV.next);
        }
    }
}