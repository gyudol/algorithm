import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int isSatisfied(int a1, int a0, int c, int n0) {
		// a1 * n0 + a0 <= c * n0
		if(a1 > c || (a1 == c && a0 > 0)) return 0;
		else if(a1 == c) return 1;
		else {	// a1 < c
			if(a1 * n0 + a0 <= c * n0) return 1;	// 최소값 n0만 만족하면 만족
			return 0;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken()), a0 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine()), n0 = Integer.parseInt(br.readLine());
		
		System.out.print(isSatisfied(a1, a0, c, n0));
	}
}