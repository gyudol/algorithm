import java.util.List;
import java.util.ArrayList;

class Solution {
    static final int MAX_PROGRESS = 100;
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployments = new ArrayList<>();
        int prevTerm = 0, cnt = 0;
        
        for (int i = 0; i < progresses.length; i++, cnt++) {
            int curTerm = (int) Math.ceil((MAX_PROGRESS - progresses[i]) * 1.0 / speeds[i]);
            
            if (curTerm > prevTerm) {
                deployments.add(cnt);
                prevTerm = curTerm;
                cnt = 0;
            }
        }
        
        deployments.add(cnt);
        
        return deployments.subList(1, deployments.size())
            .stream().mapToInt(Integer::intValue).toArray();
    }
}