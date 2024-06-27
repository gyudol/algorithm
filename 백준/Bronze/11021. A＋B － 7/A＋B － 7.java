import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			result.append('C').append('a').append('s').append('e').append(' ')
				.append('#').append(tc).append(':').append(' ')
				.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
				.append('\n');
		}

		System.out.print(result);
	}
}