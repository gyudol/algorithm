import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedMap = new HashMap<>();
        Map<String, Integer> terminal = new HashMap<>();
        int[] mails = new int[id_list.length];
        int idx = 0;
        
        for(String id : id_list) {
            reportedMap.put(id, new HashSet<>());
            terminal.put(id, idx++);
        }
        
        for(String relation : report) {
            String[] people = relation.split(" ");
            
            reportedMap.get(people[1]).add(people[0]);
        }
        
        for(int i = 0; i < mails.length; i++) {
            if(reportedMap.get(id_list[i]).size() < k) continue;
            
            for(String recipient : reportedMap.get(id_list[i]))
                mails[terminal.get(recipient)]++;
        }
        
        return mails;
    }
}