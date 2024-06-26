import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int cnt;
	private static int N;
	
	private static boolean promising(int depth, int curCol, int [] isVisited) {
		for(int row = 0; row < depth; row++) {
			if(curCol == isVisited[row]) return false;
			if(depth - row == Math.abs(curCol - isVisited[row])) return false;
		}
		
		return true;
	}
	
	private static void nQueen(int depth, int [] isVisited) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(!promising(depth, col, isVisited)) continue;
			
			isVisited[depth] = col;
			nQueen(depth + 1, isVisited);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		
		nQueen(0, new int [N]);
		
		System.out.print(cnt);
	}
}