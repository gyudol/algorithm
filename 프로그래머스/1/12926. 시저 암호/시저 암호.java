import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    private static final int LENGTH = 26;
    
    private char caesarCipher(char c, int n) {
        if(c == ' ') return c;
        
        char offset = c >= 'A' && c <= 'Z' ? 'A' : 'a';
        
        return (char) ((c - offset + n) % LENGTH + offset);
    }
    
    public String solution(String s, int n) {
        return IntStream.range(0, s.length())
            .map(i -> caesarCipher(s.charAt(i), n))
            .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append)
            .toString();
    }
}