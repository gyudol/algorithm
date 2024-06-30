import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 3;
	
	private static String typeOfTriangle(int [] t) {
		if(t[2] >= t[1] + t[0]) return "Invalid";
		if(t[0] == t[1] && t[1] == t[2]) return "Equilateral";
		if(t[0] == t[1] || t[0] == t[2] || t[1] == t[2]) return "Isosceles";
		return "Scalene";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] triangle = new int [LEN];
			
			for(int i = 0; i < LEN; i++) triangle[i] = Integer.parseInt(st.nextToken());
			if(triangle[0] == 0) break;
			
			Arrays.sort(triangle);
			result.append(typeOfTriangle(triangle)).append('\n');
		}
		
		System.out.print(result);
	}
}