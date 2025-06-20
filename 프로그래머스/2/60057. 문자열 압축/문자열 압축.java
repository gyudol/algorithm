class Solution {
    static int compress(String s, int len) {
        int cnt = 1, compressed = 0;
        
        for (int src = 0; src <= s.length() - len * 2; src += len) {
            if (s.substring(src, src + len).equals(
                s.substring(src + len, src + len * 2))) {
                
                cnt++;
            } else {
                if (cnt > 1) {
                    compressed += Integer.toString(cnt).length();
                    cnt = 1;
                }
                
                compressed += len;
            }
        }
        
        // 압축하고 남은 길이를 더해줌
        if (cnt > 1) {
            compressed += Integer.toString(cnt).length();
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