class Solution {
	static int countTotalScores(int total, int[] scores) {
		boolean[] isSelected = new boolean[total + 1];
		isSelected[0] = true;
		
		for (int score : scores) {
			// 점수 조합의 중복 적용을 막기 위해 역순으로 순회
			for (int i = total - 1; i >= 0; i--) {
				if (isSelected[i]) isSelected[score + i] = true;
			}
		}
		
		int cnt = 0;
		
		for (boolean possible : isSelected) {
			if (possible) cnt++;
		}
		
		return cnt;
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
            int total = 0;
            int[] scores = new int[N];
            
            for (int i = 0; i < N; i++) {
            	total += scores[i] = readInt();
            }
            
            result.append('#').append(tc).append(' ')
            	.append(countTotalScores(total, scores)).append('\n');
        }
        
        System.out.print(result);
    }
}