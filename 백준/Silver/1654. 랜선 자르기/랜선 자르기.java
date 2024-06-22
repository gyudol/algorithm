import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int predN(int [] lanCables, int predK) {
		int sum = 0;
		
		for(int lan : lanCables) sum += lan / predK;
		
		return sum;
	}
	
	private static long binarySearch(int [] lanCables, int N, int K) {
		long start = 1;							// [start, end)
		long end = lanCables[K - 1] + 1L;		// 최대값 2^31 - 1 => 더하기 연산시 int 범위 넘음
	
		while(end - start > 1) {
			int mid = (int) ((start + end) / 2);
			int value = predN(lanCables, mid);
			
			if(value >= N) start = mid;
			else end = mid;
		}
		
		// if(value < N) return -1;
		return start;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int [] lanCables = new int [K];
		
		for(int i = 0; i < K; i++) lanCables[i] = Integer.parseInt(br.readLine());
		Arrays.sort(lanCables);
		
		System.out.print(binarySearch(lanCables, N, K));
	}
}