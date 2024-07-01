import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] scores = new int [n];
		
		for(int i = 0; i < n; i++) scores[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(scores);
		
		System.out.print(scores[n - k]);
	}
}