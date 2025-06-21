import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    Map<String, List<Integer>> scoreMap;
    
    void generate(int depth, String prefix, int score, String[] tokens) {
        if (depth == tokens.length - 1) {
            scoreMap.putIfAbsent(prefix, new ArrayList<>());
            scoreMap.get(prefix).add(score);
            return;
        }
        
        generate(depth + 1, prefix + tokens[depth], score, tokens);
        generate(depth + 1, prefix + "-", score, tokens);
    }
    
    int binarySearch(int score, List<Integer> scores) {
        int start = 0, end = scores.size() - 1;
        
        while (end > start) {
            int mid = (start + end) / 2;
            
            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if (scores.get(end) >= score) return end;
        return scores.size();
    }
    
    int count(String query) {
        String[] tokens = query.split(" (and )?"); // 공백 한 칸 뒤에 "and"가 있거나 없음
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        
        if (!scoreMap.containsKey(key)) return 0;
        
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        List<Integer> scores = scoreMap.get(key);
        
        return scores.size() - binarySearch(score, scores);
    }
    
    public int[] solution(String[] infos, String[] queries) {
        scoreMap = new HashMap<>();
        
        for (String info : infos) {
            String[] tokens = info.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            
            generate(0, "", score, tokens);
        }
        
        for (List<Integer> list : scoreMap.values()) {
            Collections.sort(list);
        }
        
        int[] counts = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            counts[i] = count(queries[i]);
        }
        
        return counts;
    }
}