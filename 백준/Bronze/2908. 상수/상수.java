import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int reverseNum(String num) {
		return Integer.parseInt(new StringBuilder(num).reverse().toString());
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = reverseNum(st.nextToken()), b = reverseNum(st.nextToken());
		
		System.out.print(a > b ? a : b);
	}
}