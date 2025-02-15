import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MIN = 0, MAX = 10;
	
	private static int permutation(int[] seq) {
		int maxLen = 0, before = MIN, cnt = 0;
		
		for(int num : seq) {
			if(num >= before) maxLen = Math.max(++cnt, maxLen);
			else cnt = 1;
			
			before = num;
		}
		
		before = MAX;	cnt = 0;
		
		for(int num : seq) {
			if(num <= before) maxLen = Math.max(++cnt, maxLen);
			else cnt = 1;
			
			before = num;
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		
		for(int i = 0; i < seq.length; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		System.out.print(permutation(seq));
	}
}