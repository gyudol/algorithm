class Solution {
    private static final int LENGTH = 26;
    
    private char caesarEncryption(char c, int n) {
        if(c == ' ') return c;
        
        int offset = c >= 'a' && c <= 'z' ? 'a' : 'A';
        int pos = c - offset;
        
        return (char) (((pos + n) % LENGTH) + offset);
    }
    
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();
        
        for(char c : s.toCharArray()) result.append(caesarEncryption(c, n));
        return result.toString();
    }
}