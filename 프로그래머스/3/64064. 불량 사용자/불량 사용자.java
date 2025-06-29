import java.util.Set;
import java.util.HashSet;

class Solution {
    String[] appliedUsers, bannedUsers;
    
    void generate(int depth, int selected, Set<Integer> sanctions) {
        if (depth == bannedUsers.length) {
            sanctions.add(selected);
            return;
        }
        
        for (int i = 0; i < appliedUsers.length; i++) {
            if ((selected & 1 << i) != 0 || !appliedUsers[i].matches(bannedUsers[depth])) continue;
            
            selected |= 1 << i;
            generate(depth + 1, selected, sanctions);
            selected ^= 1 << i;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        Set<Integer> sanctions = new HashSet<>();
        appliedUsers = user_id;
        bannedUsers = banned_id;
        
        for (int i = 0; i < bannedUsers.length; i++) {
            bannedUsers[i] = bannedUsers[i].replace("*", ".");
        }
        
        generate(0, 0, sanctions);
        return sanctions.size();
    }
}