import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(Integer::toString)
            .sorted((s1, s2) -> {
                int original = Integer.parseInt(s1 + s2),
                    reversed = Integer.parseInt(s2 + s1);
                
                return Integer.compare(reversed, original);
            })
            .collect(Collectors.joining())
            .replaceAll("^0+", "0");
    }
}