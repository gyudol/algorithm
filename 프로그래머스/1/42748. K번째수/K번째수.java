import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] kArray = new int[commands.length];
        int idx = 0;
        
        for(int[] command : commands)
            kArray[idx++] = Arrays.stream(array, command[0] - 1, command[1])
                .boxed().sorted().collect(Collectors.toList()).get(command[2] - 1);
        
        return kArray;
    }
}