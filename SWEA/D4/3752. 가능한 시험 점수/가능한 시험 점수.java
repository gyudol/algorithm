import java.util.HashSet;
import java.util.Set;

class Solution {
	static void generate(int src, Set<Integer> scoreSet) {
		Set<Integer> tmpSet = new HashSet<>(scoreSet);
		
		for (int score : tmpSet) {
			scoreSet.add(src + score);
		}
	}
	
	static int countTotalScores(int[] scores) {
		Set<Integer> scoreSet = new HashSet<>();
		
		scoreSet.add(0);
		for (int src : scores) {
			generate(src, scoreSet);
		}
		
		return scoreSet.size();
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
    public static void main(String[] args) throws Exception {
        final int T = readInt();
        StringBuilder result = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            final int N = readInt();
            int[] scores = new int[N];
            
            for (int i = 0; i < N; i++) {
            	scores[i] = readInt();
            }
            
            result.append('#').append(tc).append(' ')
            	.append(countTotalScores(scores)).append('\n');
        }
        
        System.out.print(result);
    }
}