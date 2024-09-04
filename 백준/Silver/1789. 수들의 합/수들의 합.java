import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long n = (long) Math.sqrt(s);
		
		while(n * (n + 1) / 2 <= s) n++;
		
		System.out.print(n - 1);
	}
}