import java.util.ArrayDeque;
import java.util.Deque;

class Main {
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		final int N = readInt();
		StringBuilder result = new StringBuilder();
		
		int[] skills = new int[N];
		Deque<Integer> cards = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			skills[i] = readInt();
		}
		
		for (int i = 1; i <= N; i++) {
			switch (skills[N - i]) {	// 놓여 있는 카드들은 높이가 높을수록 최근에 배치된 카드
				case 1: 
					cards.offerFirst(i);
					break;
				case 2: 
					int top = cards.pollFirst();
					
					cards.offerFirst(i);
					cards.offerFirst(top);
					break;
				case 3: 
					cards.offerLast(i);
					break;
			}
		}
		
		for (int card : cards) {
			result.append(card).append(' ');
		}
		
		System.out.print(result);
	}
}