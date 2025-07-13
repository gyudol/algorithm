import java.util.TreeMap;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            int data = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case "I": 
                    countMap.put(data, countMap.getOrDefault(data, 0) + 1);
                    break;
                case "D": {
                    if (countMap.isEmpty()) break;
                    
                    int key = data == 1 ? countMap.lastKey() : countMap.firstKey(),
                        count = countMap.get(key);
                    
                    if (count == 1) {
                        countMap.remove(key);
                    } else {
                        countMap.put(key, count - 1);
                    }
                }
            }
        }
        
        return countMap.isEmpty()
            ? new int[] {0, 0}
            : new int[] {countMap.lastKey(), countMap.firstKey()};
    }
}