import java.util.stream.IntStream;

class Solution {
    private static final int[][] GUESS = {
        {1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    
    public int[] solution(int[] answers) {
        int max = 0, person = 0;
        int[] corrects = new int[GUESS.length];
        
        for(int[] g : GUESS) {
            int correct = 0;
            
            for(int i = 0; i < answers.length; i++) {
                if(answers[i] == g[i % g.length]) correct++;
            }
            
            corrects[person++] = correct;
            max = Math.max(correct, max);
        }
        
        final int maxCorrects = max;
        
        return IntStream.range(0, GUESS.length)
            .filter(i -> maxCorrects == corrects[i])
            .map(i -> i + 1).toArray();
    }
}