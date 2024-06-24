import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean isNumber(String str) {
		if(str.charAt(0) >= '0' && str.charAt(0) <= '9') return true;
		return false;
	}
	
	private static String nextStr(String [] fizzBuzz) {	// 3, 5, 15의 배수이므로 3개 모두 문자열인 경우는 없음
		int num = -1;
		
		for(int i = 0; i < fizzBuzz.length; i++) {
			if(isNumber(fizzBuzz[i])) {
				num = Integer.parseInt(fizzBuzz[i]) + (fizzBuzz.length - i);
				break;
			}
		}
		
		if(num % 15 == 0) return "FizzBuzz";
		else if(num % 3 == 0) return "Fizz";
		else if(num % 5 == 0) return "Buzz";
		else return Integer.toString(num);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] fizzBuzz = new String [3];
		
		for(int i = 0; i < fizzBuzz.length; i++) fizzBuzz[i] = br.readLine();
		
		System.out.print(nextStr(fizzBuzz));
	}
}