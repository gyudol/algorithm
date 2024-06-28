import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE;
		int [] scores = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			
			if(scores[i] > max) max = scores[i];
		}
		
		double sum = 0.0;
		
		for(int i = 0; i < n; i++) sum += (scores[i] * 1.0 / max * 100);
		
		System.out.print(sum / n);
	}
}