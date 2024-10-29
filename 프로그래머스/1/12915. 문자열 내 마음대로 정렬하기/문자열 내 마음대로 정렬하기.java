import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
            return Integer.compare(s1.charAt(n), s2.charAt(n));
        }).toArray(String[]::new);
    }
}