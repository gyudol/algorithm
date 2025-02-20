import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static final int N = 9;
	static int winCnt, loseCnt;
	static int[] gyuyoung, inyoung;
	
	static boolean contains(int[] cards, int num) {
		for(int card : cards) {
			if(card == num) return true;
		}
		
		return false;
	}
	
	static void playCardGame(int depth, int inScore, int gyuScore, boolean[] isSelected) {
		if(depth == N) {
			if(gyuScore > inScore) winCnt++;
			else if(gyuScore < inScore) loseCnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			int sum = gyuyoung[depth] + inyoung[i];
			isSelected[i] = true;
			
			if(gyuyoung[depth] > inyoung[i]) playCardGame(depth + 1, inScore, gyuScore + sum, isSelected);
			else playCardGame(depth + 1, inScore + sum, gyuScore, isSelected);
			
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyuyoung = new int[N];	inyoung = new int[N];
			winCnt = 0;	loseCnt = 0;
			
			for(int i = 0; i < N; i++) gyuyoung[i] = Integer.parseInt(st.nextToken());
			for(int num = 1, idx = 0; num <= N * 2; num++) {
				if(contains(gyuyoung, num)) continue;
				inyoung[idx++] = num;
			}
			
			playCardGame(0, 0, 0, new boolean[N]);
			result.append('#').append(tc).append(' ').append(winCnt).append(' ').append(loseCnt).append('\n');
		}

		System.out.print(result);
	}
}