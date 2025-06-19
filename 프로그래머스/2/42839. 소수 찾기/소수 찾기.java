import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    static void generate(int depth, int piece, String numbers, boolean[] isVisited, Set<Integer> digitSet) {
        digitSet.add(piece);
        if (depth == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (isVisited[i]) continue;
            
            isVisited[i] = true;
            generate(depth + 1, piece * 10 + numbers.charAt(i) - '0', numbers, isVisited, digitSet);
            isVisited[i] = false;
        }
    }
    
    static int countPrimeNumbers(Set<Integer> digitSet) {
        final int MAX_NUMBER = Collections.max(digitSet);
        boolean[] isNotPrime = new boolean[MAX_NUMBER + 1];
        int cnt = 0;
        
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX_NUMBER); i++) {
            if (isNotPrime[i]) continue;
            
            for (int j = i * i; j <= MAX_NUMBER; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        for (int digit : digitSet) {
            if (!isNotPrime[digit]) cnt++;
        }
        
        return cnt;
    }
    
    public int solution(String numbers) {
        Set<Integer> digitSet = new HashSet<>();
        generate(0, 0, numbers, new boolean[numbers.length() + 1], digitSet);
        
        return countPrimeNumbers(digitSet);
    }
}