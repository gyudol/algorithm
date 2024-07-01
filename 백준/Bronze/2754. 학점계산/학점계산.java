import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final String [] GRADES = 
		{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-"};
	private static final double [] SCORES = 
		{4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7};
	
	private static double gpa(String grade) {
		for(int i = 0; i < GRADES.length; i++) {
			if(grade.equals(GRADES[i])) return SCORES[i];
		}
		
		return 0.0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String grade = br.readLine();
		
		System.out.print(gpa(grade));
	}
}