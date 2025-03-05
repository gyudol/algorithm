import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		int maxCnt = 3, target = 1;
		
		for (int i = N / 2; i <= N; i++) {
			int cnt = 2, before = N, cur = i;
			
			while (before - cur >= 0) {
				int tmp = cur;
				
				cur = before - cur;
				before = tmp;
				cnt++;
			}
			
			if (cnt > maxCnt) {
				maxCnt = cnt;
				target = i;
			}
		}
		
		result.append(maxCnt).append('\n');
		int before = N, cur = target;
		
		result.append(before).append(' ').append(cur).append(' ');
		while (before - cur >= 0) {
			int tmp = cur;
			
			cur = before - cur;
			before = tmp;
			result.append(cur).append(' ');
		}
		
		System.out.print(result);
	}
}