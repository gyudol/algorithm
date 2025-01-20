class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for(char c : s.toUpperCase().toCharArray()) {
            if(c == 'P') cnt++;
            else if(c == 'Y') cnt--;
        }

        return cnt == 0;
    }
}