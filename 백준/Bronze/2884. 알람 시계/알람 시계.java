import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		
		if(m - 45 < 0) {
			h--;
			m += 15;
			
			if(h < 0) h += 24;
		}
		else m -= 45;
		
		result.append(h).append(' ').append(m);

		System.out.print(result);
	}
}