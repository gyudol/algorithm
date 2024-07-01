import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()), 
					w = Integer.parseInt(st.nextToken()),
					n = Integer.parseInt(st.nextToken());
			int floor = (n - 1) % h + 1, 
					room = (n - 1) / h + 1;
			
			result.append(floor);
			if(room < 10) result.append(0);
			result.append(room).append('\n');
		}
		
		System.out.print(result);
	}
}