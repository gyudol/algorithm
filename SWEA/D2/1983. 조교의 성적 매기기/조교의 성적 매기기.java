import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static final int EVAL = 3;
	private static final String[] GRADES = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
	
	private static int indexOf(double[] total, double target) {
		int start = 0, end = total.length;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(total[mid] == target) return mid;
			if(total[mid] < target) start = mid + 1;
			else end = mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			int[][] scores = new int[N][EVAL];
			double[] total = new double[N];
			double target = 0.0;
			
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < EVAL; col++) scores[row][col] = Integer.parseInt(st.nextToken());
				total[row] = scores[row][0] * 0.35 + scores[row][1] * 0.45 + scores[row][2] * 0.2;
				if(row == K - 1) target = total[row];
			}
			
			Arrays.sort(total);
			result.append('#').append(tc).append(' ')
				.append(GRADES[indexOf(total, target) / (N / GRADES.length)]).append('\n');
		}
		
		System.out.print(result);
	}
}