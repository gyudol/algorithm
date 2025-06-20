class Solution {
    int compress(String s, int len) {
        int cnt = 1, compressed = 0;
        String prev = s.substring(0, len);
        
        for (int i = len; i <= s.length() - len; i += len) {
            String cur = s.substring(i, i + len);
            
            if (cur.equals(prev)) {
                cnt++;
            } else {
                if (cnt > 1) {
                    compressed += Math.log10(cnt) + 1;
                    cnt = 1;
                }
                
                prev = cur;
                compressed += len;
            }
        }
        
        if (cnt > 1) {  // 압축하고 남은 길이를 더해줌
            compressed += Math.log10(cnt) + 1;
        }
        
        return compressed + len + s.length() % len;
    }
    
    public int solution(String s) {
        int min = s.length();
        
        for (int len = 1; len <= s.length() / 2; len++) {
            min = Math.min(compress(s, len), min);
        }
        
        return min;
    }
}