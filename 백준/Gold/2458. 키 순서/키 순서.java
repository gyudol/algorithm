import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean canKnowRank(int src, boolean[][] isChecked) {
		for(int des = 1; des < isChecked.length; des++) {
			// 서로 다른 학생끼리 연결 관계가 없다면 순위를 알 수 없음
			if(src != des && (!isChecked[src][des] && !isChecked[des][src])) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		boolean[][] isChecked = new boolean[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken());
			
			isChecked[src][des] = true;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(isChecked[i][k] && isChecked[k][j]) isChecked[i][j] = true;
				}
			}
		}
		
		for(int src = 1; src <= N; src++) {
			if(canKnowRank(src, isChecked)) cnt++;
		}
		
		System.out.print(cnt);
	}
}