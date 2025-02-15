import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int permutation(int[] seq) {
		int maxLen = 0, before = seq[0], cntAsc = 0, cntDesc = 0;
		
		for(int num : seq) {
			if(num >= before) maxLen = Math.max(++cntAsc, maxLen);
			else cntAsc = 1;
			
			if(num <= before) maxLen = Math.max(++cntDesc, maxLen);
			else cntDesc = 1;
			
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