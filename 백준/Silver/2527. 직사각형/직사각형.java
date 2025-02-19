import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int T = 4;
	
	private static class Square {
		int x, y, p, q;
		
		public Square(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	
	private static char connectionCode(Square s1, Square s2) {
		if(s1.x > s2.p || s1.p < s2.x || s1.y > s2.q || s1.q < s2.y) return 'd';
		else if((s1.x == s2.p && s1.y == s2.q) || (s1.x == s2.p && s1.p == s2.y) ||
				(s1.p == s2.x && s1.y == s2.q) || (s1.p == s2.x && s1.q == s2.y)) return 'c';
		else if(s1.x == s2.p || s1.p == s2.x || s1.y == s2.q || s1.q == s2.y) return 'b';
		return 'a';
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Square s1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
					s2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					
			result.append(connectionCode(s1, s2)).append('\n');
		}
		
		System.out.print(result);
	}
}