import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static String typeOfTriangle(int a, int b, int c) {
		if(a + b + c != 180) return "Error";
		if(a == b && b == c) return "Equilateral";
		if(a == b || a == c || b == c) return "Isosceles";
		return "Scalene";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()),
				c = Integer.parseInt(br.readLine());
		
		System.out.print(typeOfTriangle(a, b, c));
	}
}