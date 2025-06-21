import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    Map<String, Integer> courseMap;
    
    void generate(int src, String course, int tgDepth, String order) {
        if (course.length() == tgDepth) {
            courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
            return;
        }
        
        for (int i = src; i < order.length(); i++) {
            generate(i + 1, course + order.charAt(i), tgDepth, order);
        }
    }
    
    public String[] solution(String[] orders, int[] courseLens) {
        courseMap = new HashMap<>();
        
        for (String order : orders) {
            char[] tmpOrder = order.toCharArray();
            
            Arrays.sort(tmpOrder);
            order = new String(tmpOrder);
            
            for (int tgDepth : courseLens) {
                generate(0, "", tgDepth, order);
            }
        }
        
        List<String> courseList = new ArrayList<>();
        
        for (int courseLen : courseLens) {
            List<String> tmpList = new ArrayList<>();
            int maxCnt = 2;     // 최소 2명 이상의 손님으로부터 주문되어야 함
            
            for (String course : courseMap.keySet()) {
                int cnt = courseMap.get(course);
                
                if (course.length() != courseLen || cnt < maxCnt) continue;
                
                if (cnt > maxCnt) {
                    tmpList.clear();
                    maxCnt = cnt;
                }
                
                tmpList.add(course);
            }
            
            courseList.addAll(tmpList);
        }
        
        return courseList.stream()
            .sorted((s1, s2) -> s1.compareTo(s2))
            .toArray(String[]::new);
    }
}