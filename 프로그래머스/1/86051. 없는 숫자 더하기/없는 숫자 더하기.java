import java.util.Arrays;

class Solution {
    private static final int TARGET = 45;
    
    public int solution(int[] numbers) {
        return TARGET - Arrays.stream(numbers).sum();
    }
}