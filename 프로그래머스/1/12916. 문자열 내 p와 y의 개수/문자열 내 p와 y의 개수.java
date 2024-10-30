class Solution {
    boolean solution(String s) {
        int pCnt = 0, yCnt = 0;
        
        for(char c : s.toUpperCase().toCharArray()) {
            switch(c) {
                case 'P': pCnt++; break;
                case 'Y': yCnt++;
            }
        }

        return pCnt == yCnt;
    }
}