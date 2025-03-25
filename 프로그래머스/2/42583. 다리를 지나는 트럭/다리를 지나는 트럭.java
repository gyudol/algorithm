import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int load = 0, sec = 0;
        
        for (int i = 0; i < bridge_length; i++) deque.offer(0);
        
        for (int truck : truck_weights) {
            while ((load -= deque.pollFirst()) + truck > weight) {
                deque.offer(0);
                sec++;
            }
            
            load += truck;
            deque.offer(truck);
            sec++;
        }
        
        return sec + bridge_length;
    }
}