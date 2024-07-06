import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] wdTime = new int [n];
		
		for(int i = 0; i < n; i++) wdTime[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(wdTime);
		
		int sum = wdTime[0];
		for(int i = 1; i < n; i++) sum += wdTime[i] += wdTime[i - 1];
		
		System.out.print(sum);
	}
}