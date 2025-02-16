import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int M = 6;
	
	private static int getArea(int[] moves, int maxHeight, int maxWidth, int hIdx, int wIdx) {
		int heightDiff = Math.abs(moves[(hIdx - 1 + M) % M] - moves[(hIdx + 1) % M]),
				widthDiff = Math.abs(moves[(wIdx - 1 + M) % M] - moves[(wIdx + 1) % M]);
		
		return maxHeight * maxWidth - heightDiff * widthDiff;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int K = Integer.parseInt(br.readLine());
		int[] moves = new int[M];
		int maxHeight = 0, maxWidth = 0, hIdx = -1, wIdx = -1;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()), offset = Integer.parseInt(st.nextToken());
			moves[i] = offset;

			if((d == 3 || d == 4) && offset > maxHeight) {
					maxHeight = offset;
					hIdx = i;
			}
			else if((d == 1 || d == 2) && offset > maxWidth) {
					maxWidth = offset;
					wIdx = i;
			}
		}
		
		System.out.print(getArea(moves, maxHeight, maxWidth, hIdx, wIdx) * K);
	}
}