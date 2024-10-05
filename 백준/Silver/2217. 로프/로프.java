import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		int maxLoad = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) ropes[i] = Integer.parseInt(br.readLine());
		Arrays.sort(ropes);
		
		for(int i = 0; i < N; i++) maxLoad = Math.max(maxLoad, ropes[i] * (N - i));
		
		System.out.print(maxLoad);
	}
}