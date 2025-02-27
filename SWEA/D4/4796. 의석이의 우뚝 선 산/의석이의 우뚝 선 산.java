import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class Solution {
	static int getIntervalCount(int N, int[] heights) {
		int cnt = 0, src = 0, mid = 0, des = 1;
		
		while(des < N) {
			while(des < N && (heights[des - 1] < heights[des])) mid = des++;
			while(des < N && (heights[des - 1] > heights[des])) des++;

			cnt += (mid - src) * (des - mid - 1);
			src = mid = des - 1;
		}
		
		return cnt;
	}
	
	static int readNextInt(StreamTokenizer st) throws Exception {
		st.nextToken();
		return (int) st.nval;
	}
	
	public static void main(String[] args) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = readNextInt(st);
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = readNextInt(st);
			int[] heights = new int[N];
			
			for(int i = 0; i < N; i++) heights[i] = readNextInt(st);
			
			result.append('#').append(tc).append(' ')
				.append(getIntervalCount(N, heights)).append('\n');
		}
		
		System.out.print(result);
	}
}