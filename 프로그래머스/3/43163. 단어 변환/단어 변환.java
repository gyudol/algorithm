import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean isConvertible(String cur, String next) {
        int diff = 0;
        
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        
        Deque<State> q = new ArrayDeque<>();
        boolean[] isSelected = new boolean[words.length];
        
        q.offer(new State(begin, 0));
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            String word = cur.word;
            int depth = cur.depth;
            
            if (word.equals(target)) return depth;
            
            for (int i = 0; i < words.length; i++) {
                if (isSelected[i] || !isConvertible(word, words[i])) continue;
                
                isSelected[i] = true;
                q.offer(new State(words[i], depth + 1));
            }
        }
        
        return 0;
    }
    
    class State implements Comparable<State> {
        String word;
        int depth;
        
        State(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
        
        @Override
        public int compareTo(State o) {
            return Integer.compare(depth, o.depth);
        }
    }
}