import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int openedWindows(int n) {
		int cnt = 0;
		
		for(int i = 1; i <= Math.sqrt(n); i++) cnt++;
		
		return cnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(openedWindows(n));
	}
}