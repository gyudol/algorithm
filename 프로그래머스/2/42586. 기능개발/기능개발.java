import java.util.List;
import java.util.ArrayList;

class Solution {
    static final int MAX_PROGRESS = 100;
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployments = new ArrayList<>();
        int prevTerm = 0, prevIdx = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int curTerm = (MAX_PROGRESS - progresses[i]) % speeds[i] > 0 ?
                (MAX_PROGRESS - progresses[i]) / speeds[i] + 1 :
                (MAX_PROGRESS - progresses[i]) / speeds[i];
            
            if (curTerm > prevTerm) {
                deployments.add(i - prevIdx);
                prevIdx = i;
                prevTerm = curTerm;
            }
        }
        
        deployments.add(progresses.length - prevIdx);
        
        return deployments.subList(1, deployments.size())
            .stream().mapToInt(Integer::intValue).toArray();
    }
}