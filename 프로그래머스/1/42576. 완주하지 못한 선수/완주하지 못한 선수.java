import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String person : participant) map.put(person, map.getOrDefault(person, 0) + 1);
        
        for(String person : completion) {
            map.put(person, map.get(person) - 1);
            if(map.get(person) == 0) map.remove(person);
        }
        
        return map.keySet().iterator().next();
    }
}