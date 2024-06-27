import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		
		result.append(a+b).append('\n').append(a-b).append('\n')
			.append(a*b).append('\n').append(a/b).append('\n').append(a%b);
		
		System.out.print(result);
	}
}