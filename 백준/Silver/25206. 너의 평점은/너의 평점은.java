import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 20;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Double> grades = new HashMap<String, Double>() {
			private static final long serialVersionUID = 1L;	// 누락시 경고 메시지
			{
				put("A+", 4.5); put("A0", 4.0); put("B+", 3.5); put("B0", 3.0);
				put("C+", 2.5); put("C0", 2.0); put("D+", 1.5); put("D0", 1.0); put("F", 0.0);
		}};		// anonymous class
		double sum = 0.0;
		int crdSum = 0;
		
		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(grade.equals("P")) continue;
			
			crdSum += credit;
			sum += credit * grades.get(grade);
		}
		
		System.out.print(sum / crdSum);
	}
}