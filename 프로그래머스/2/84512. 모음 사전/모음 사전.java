import java.util.List;
import java.util.ArrayList;

class Solution {
    final char[] WORDS = {'A', 'E', 'I', 'O', 'U'};
    
    void generate(String word, List<String> dictionary) {
        dictionary.add(word);
        if (word.length() == WORDS.length) return;
        
        for (char c : WORDS) {
            generate(word + c, dictionary);
        }
    }
    
    public int solution(String word) {
        List<String> dictionary = new ArrayList<>();
        
        generate("", dictionary);
        return dictionary.indexOf(word);
    }
}