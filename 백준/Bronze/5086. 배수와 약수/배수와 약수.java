import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static String relation(int a, int b) {
		if(b % a == 0) return "factor";
		else if(a % b == 0) return "multiple";
		
		return "neither";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		
			if(a == 0) break;
			
			result.append(relation(a, b)).append('\n');
		}
		
		System.out.print(result);
	}
}