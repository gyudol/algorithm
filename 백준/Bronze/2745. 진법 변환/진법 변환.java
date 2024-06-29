import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int radix = Integer.parseInt(st.nextToken());
		
		System.out.print(Integer.parseInt(num, radix));
	}
}