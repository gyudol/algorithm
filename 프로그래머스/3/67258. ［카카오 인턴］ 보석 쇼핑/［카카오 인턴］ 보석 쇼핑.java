import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> gemWindow = new HashMap<>();
        int totalGemTypes = new HashSet<>(Arrays.asList(gems)).size();
        int src = 0, start = src + 1, end = gems.length;
        
        for (int des = 0; des < gems.length; des++) {
            gemWindow.put(gems[des], gemWindow.getOrDefault(gems[des], 0) + 1);
            
            while (gemWindow.size() == totalGemTypes) {
                if (des - src < end - start) {
                    end = des + 1;
                    start = src + 1;
                }
                
                String deleted = gems[src++];
                gemWindow.put(deleted, gemWindow.get(deleted) - 1);
                
                if (gemWindow.get(deleted) == 0) {
                    gemWindow.remove(deleted);
                }
            }
        }
        
        return new int[] {start, end};
    }
}