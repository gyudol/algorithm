import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int dialTime(char c) {
		int num = -1;
		
		if(c <= 'R') num = (c - 'A') / 3 + 2;
		else if(c == 'S') num = 7;
		else if(c == 'T' || c == 'U' || c == 'V') num = 8;
		else num = 9;
		
		return num + 1;		// num - 2 + 1
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int sum = 0;
		
		for(char c : word.toCharArray()) sum += dialTime(c);
		
		System.out.print(sum);
	}
}