import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportLog = new HashMap<>();
        Map<String, Integer> reporterCnt = new HashMap<>();
        
        for(String id : id_list) {
            reportLog.put(id, new HashSet<>());
            reporterCnt.put(id, 0);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] sliced = report[i].split(" ");
            
            reportLog.get(sliced[1]).add(sliced[0]);
        }
        
        for(String reported : reportLog.keySet()) {
            if(reportLog.get(reported).size() < k) continue;
            
            for(String reporter : reportLog.get(reported))
                reporterCnt.put(reporter, reporterCnt.get(reporter) + 1);
        } 
        
        for(int i = 0; i < id_list.length; i++) answer[i] = reporterCnt.get(id_list[i]);
        
        return answer;
    }
}