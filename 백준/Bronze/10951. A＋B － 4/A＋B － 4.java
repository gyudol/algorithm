import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			String line = br.readLine();
			
			if(line == null) break;
			
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());			
			
			result.append(a + b).append('\n');
		}
			
		System.out.print(result);
	}
}