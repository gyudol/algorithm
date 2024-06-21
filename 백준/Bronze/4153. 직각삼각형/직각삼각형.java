import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int LEN = 3;
	
	private static String isRightTriangle(int [] triangle) {
		for(int i = 0; i < LEN; i++) triangle[i] *= triangle[i];
		
		return triangle[2] == triangle[0] + triangle[1] ? "right" : "wrong";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			int [] triangle = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			if(triangle[0] == 0) break;
			
			Arrays.sort(triangle);
			result.append(isRightTriangle(triangle)).append('\n');
		}
		
		System.out.print(result);
	}
}