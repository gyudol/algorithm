import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		int idx = 0;
		int[] arr = new int[a + b];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) arr[idx++] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++) arr[idx++] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		for(int num : arr) result.append(num).append(' ');
		
		System.out.print(result);
	}
}