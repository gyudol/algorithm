import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    Node trie, reversedTrie;
    
    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    int count(String query) {
        if (query.startsWith("?")) return reversedTrie.count(reverse(query), 0);
        return trie.count(query, 0);
    }
    
    public int[] solution(String[] words, String[] queries) {
        trie = new Node();
        reversedTrie = new Node();
        
        for (String word : words) {
            trie.add(word, 0);
            reversedTrie.add(reverse(word), 0);
        }
        
        return Arrays.stream(queries)
            .mapToInt(query -> count(query))
            .toArray();
    }
    
    class Node {
        Map<Integer, Integer> terminals = new HashMap<>();
        Map<Character, Node> children = new HashMap<>();
        
        void add(String word, int offset) {
            int length = word.length() - offset;
            
            terminals.put(length, terminals.getOrDefault(length, 0) + 1);
            if (length == 0) return;
            
            char c = word.charAt(offset);
            Node child = children.getOrDefault(c, new Node());
            
            child.add(word, offset + 1);
            children.put(c, child);
        }
        
        int count(String query, int offset) {
            char c = query.charAt(offset);
            
            if (c == '?') return terminals.getOrDefault(query.length() - offset, 0);
            if (!children.containsKey(c)) return 0;
            
            return children.get(c).count(query, offset + 1);
        }
    }
}