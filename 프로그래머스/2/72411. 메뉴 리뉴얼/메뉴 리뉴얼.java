import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    Map<String, Integer> courseMap;
    
    void generate(int src, StringBuilder course, int tgDepth, char[] order) {
        if (course.length() == tgDepth) {
            String key = course.toString();
            
            courseMap.put(key, courseMap.getOrDefault(key, 0) + 1);
            return;
        }
        
        for (int i = src; i < order.length; i++) {
            course.append(order[i]);
            generate(i + 1, course, tgDepth, order);
            course.deleteCharAt(course.length() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] sizes) {
        courseMap = new HashMap<>();
        
        for (String order : orders) {
            char[] sortedOrder = order.toCharArray();
            Arrays.sort(sortedOrder);
            
            for (int tgDepth : sizes) {
                generate(0, new StringBuilder(), tgDepth, sortedOrder);
            }
        }
        
        List<String> courseList = new ArrayList<>();
        
        for (int size : sizes) {
            List<String> candidates = new ArrayList<>();
            int maxCnt = 2;     // 최소 2명 이상의 손님으로부터 주문되어야 함
            
            for (String course : courseMap.keySet()) {
                int cnt = courseMap.get(course);
                
                if (course.length() != size || cnt < maxCnt) continue;
                
                if (cnt > maxCnt) {
                    candidates.clear();
                    maxCnt = cnt;
                }
                
                candidates.add(course);
            }
            
            courseList.addAll(candidates);
        }
        
        return courseList.stream().sorted().toArray(String[]::new);
    }
}