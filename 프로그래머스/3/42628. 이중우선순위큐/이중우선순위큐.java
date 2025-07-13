import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (n1, n2) -> Integer.compare(n2, n1));
        
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            int data = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case "I": minHeap.offer(data);
                    maxHeap.offer(data);
                    break;
                case "D": {
                    if (data == 1) {
                        minHeap.remove(maxHeap.poll());
                    } else {
                        maxHeap.remove(minHeap.poll());
                    }
                }
            }
        }
        
        return minHeap.size() == 0 ?
            new int[] {0, 0} :
            new int[] {maxHeap.poll(), minHeap.poll()};
    }
}