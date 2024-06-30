import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int binarySearch(int target, int [] arr) {
		int start = 0, end = arr.length;	// [start, end)
		
		while(end > start) {
			int mid = (start + end) / 2;
			int value = arr[mid];
			
			if(value == target) return 1;
			else if(value > target) end = mid;
			else start = mid + 1;
		}
		
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		Integer.parseInt(br.readLine());
		int [] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted().toArray();
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++)
			result.append(binarySearch(Integer.parseInt(st.nextToken()), arr)).append('\n');
		
		System.out.print(result);
	}
}