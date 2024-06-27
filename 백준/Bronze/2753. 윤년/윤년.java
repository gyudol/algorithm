import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int isLeapYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) return 1;
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		
		System.out.print(isLeapYear(year));
	}
}