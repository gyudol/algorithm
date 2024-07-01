import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MIN = -999;
	private static final int MAX = 999;
	
	private static String equation(int a, int b, int c, int d, int e, int f) {
		for(int x = MIN; x <= MAX; x++) {
			for(int y = MIN; y <= MAX; y++) {
				if(a * x + b * y == c && d * x + e * y == f)
					return new StringBuilder().append(x).append(' ').append(y).toString();
			}
		}
		
		return "Invalid";	// 방정식을 만족하는 (x, y)는 유일하게 존재
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
				c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
				e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());
		
		System.out.print(equation(a, b, c, d, e, f));
	}
}