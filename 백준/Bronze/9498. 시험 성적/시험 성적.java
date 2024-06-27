import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int [][] RANGE = {{90, 100}, {80, 89}, {70, 79}, {60, 69}};
	private static final char [] GRADE = {'A', 'B', 'C', 'D', 'F'};
	
	private static char grade(int score) {
		for(int i = 0; i < RANGE.length; i++) {
			if(score >= RANGE[i][0] && score <= RANGE[i][1]) return GRADE[i];
		}
		
		return GRADE[GRADE.length - 1];
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		
		System.out.print(grade(score));
	}
}