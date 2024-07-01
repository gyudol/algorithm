import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	
	private static int maxCnt(int [][] meetings, int src, int endTime, int cnt) {
		for(int i = src; i < n; i++) {
			if(meetings[i][0] >= endTime) return maxCnt(meetings, i + 1, meetings[i][1], cnt + 1);
		}
		
		return cnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int [][] meetings = new int [n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, (m1, m2) -> {		// endTime 기준으로 sort
			if(m1[1] == m2[1]) return Integer.compare(m1[0], m2[0]);
			return Integer.compare(m1[1], m2[1]);
		});
		
		System.out.print(maxCnt(meetings, 0, 0, 0));
	}
}