import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

class Solution {
    void forEachKey(int depth, String prefix, String[] tokens, Consumer<String> action) {
        if (depth == tokens.length - 1) {
            action.accept(prefix);
            return;
        }
        
        forEachKey(depth + 1, prefix + tokens[depth], tokens, action);
        forEachKey(depth + 1, prefix + "-", tokens, action);
    }
    
    Map<String, List<Integer>> buildScoreMap(String[] infos) {
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        
        for (String info : infos) {
            String[] tokens = info.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            
            forEachKey(0, "", tokens, key -> {
                scoreMap.putIfAbsent(key, new ArrayList<>());
                scoreMap.get(key).add(score);
            });
        }
        
        for (List<Integer> list : scoreMap.values()) {
            Collections.sort(list);
        }
        
        return scoreMap;
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
    
    int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and )?"); // 공백 한 칸 뒤에 "and"가 있거나 없음
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        
        if (!scoreMap.keySet().contains(key)) return 0;
        
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        List<Integer> scores = scoreMap.get(key);
        
        return scores.size() - binarySearch(score, scores);
    }
    
    public int[] solution(String[] infos, String[] queries) {
        Map<String, List<Integer>> scoreMap = buildScoreMap(infos);
        int[] counts = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            counts[i] = count(queries[i], scoreMap);
        }
        
        return counts;
    }
}