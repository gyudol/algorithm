import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int offsetM = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		m += offsetM;
		
		if(m > 59) {
			int offsetH = m / 60;
			m = m % 60;
			h = (h + offsetH) % 24;
		}
		
		result.append(h).append(' ').append(m);

		System.out.print(result);
	}
}