class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for(char c : s.toUpperCase().toCharArray()) {
            switch(c) {
                case 'P': cnt++; break;
                case 'Y': cnt--;
            }
        }

        return cnt == 0;
    }
}