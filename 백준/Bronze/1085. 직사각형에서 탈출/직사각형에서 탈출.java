import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int min(int a, int b, int c, int d) {
		return Math.min(Math.min(Math.min(a, b), c), d);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
				w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		
		System.out.print(min(x, y, w - x, h - y));
	}
}