import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int [] trees;
	
	private static long woodCutting(long height) {
		long sum = 0;
		
		for(int i = n - 1; i >= 0; i--) {
			if(trees[i] - height <= 0) break;
			
			sum += trees[i] - height;
		}
			
		return sum;
	}
	
	private static long binarySearch() {
		long start = 0, end = trees[n - 1];	// [start, end)
		
		while(end - start > 1) {
			long mid = (start + end) / 2;
			
			if(woodCutting(mid) >= m) start = mid;
			else end = mid;
		}
		
		return start;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		trees = new int [n];
		
		for(int i = 0; i < n; i++) trees[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(trees);
		
		System.out.print(binarySearch());
	}
}