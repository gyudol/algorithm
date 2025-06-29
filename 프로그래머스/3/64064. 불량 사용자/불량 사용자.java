import java.util.Set;
import java.util.HashSet;

class Solution {
    String[] appliedUsers, bannedUsers;
    
    void generate(int depth, boolean[] isSelected, Set<String> sanctions) {
        if (depth == bannedUsers.length) {
            String selectedNumbers = "";
            
            for (int i = 0; i < isSelected.length; i++) {
                if (!isSelected[i]) continue;
                selectedNumbers += i;
            }
            
            sanctions.add(selectedNumbers);
            return;
        }
        
        for (int i = 0; i < appliedUsers.length; i++) {
            if (isSelected[i] || !appliedUsers[i].matches(bannedUsers[depth])) continue;
            
            isSelected[i] = true;
            generate(depth + 1, isSelected, sanctions);
            isSelected[i] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        Set<String> sanctions = new HashSet<>();
        appliedUsers = user_id;
        bannedUsers = banned_id;
        
        for (int i = 0; i < bannedUsers.length; i++) {
            bannedUsers[i] = bannedUsers[i].replace("*", ".");
        }
        
        generate(0, new boolean[appliedUsers.length], sanctions);
        return sanctions.size();
    }
}