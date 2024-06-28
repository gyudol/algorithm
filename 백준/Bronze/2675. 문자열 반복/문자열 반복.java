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
			int loop = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(char c : s.toCharArray()) {
				for(int i = 0; i < loop; i++) result.append(c);
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}