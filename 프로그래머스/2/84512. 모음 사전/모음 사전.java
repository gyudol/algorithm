class Solution {
    final char[] WORDS = {'A', 'E', 'I', 'O', 'U'};
    int index = 0;
    
    boolean dfs(String word, String target) {
        if (word.equals(target)) return true;
        if (word.length() == WORDS.length) return false;
        
        for (char c : WORDS) {
            index++;
            if (dfs(word + c, target)) return true;
        }
        
        return false;
    }
    
    public int solution(String word) {
        dfs("", word);
        return index;
    }
}