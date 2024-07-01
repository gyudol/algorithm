import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int isSatisfied(int a1, int a0, int c, int n0) {
		// 최솟값 n0에 대해서만 만족하면 식이 성립
		if(a1 * n0 + a0 <= c * n0 && c >= a1) return 1;
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken()), a0 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine()), n0 = Integer.parseInt(br.readLine());
		
		System.out.print(isSatisfied(a1, a0, c, n0));
	}
}