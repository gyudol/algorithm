import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static int cnt;
	
	private static boolean promising(int [] isVisited, int depth, int col) {
		for(int i = 0; i < depth; i++) {
			if(isVisited[i] == col) return false;
			else if(depth - i == Math.abs(col - isVisited[i])) return false;
		}
		
		return true;
	}
	
	private static void nQueen(int [] isVisited, int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(!promising(isVisited, depth, col)) continue;
			
			isVisited[depth] = col;
			nQueen(isVisited, depth + 1);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		
		nQueen(new int [N], 0);
		System.out.print(cnt);
	}
}