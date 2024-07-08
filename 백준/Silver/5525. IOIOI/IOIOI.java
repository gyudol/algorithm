import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int m;
	private static String str;
	
	private static String getPattern(int n) {
		StringBuilder sb = new StringBuilder().append('I').append('O').append('I');
		
		for(int i = 2; i <= n; i++) sb.append('O').append('I');
		
		return sb.toString();
	}
	
	private static int [] buildLps(String pattern) {
		int [] lps = new int [pattern.length()];
		int len = 0;	// prev lps length
		
		for(int i = 1; i < pattern.length(); i++) {
			while(len > 0 && pattern.charAt(i) != pattern.charAt(len)) len = lps[len - 1];
			
			if(pattern.charAt(i) == pattern.charAt(len)) lps[i] = ++len;
		}
		
		return lps;
	}
	
	private static int kmpSearch(String pattern) {
		int [] lps = buildLps(pattern);
		int cnt = 0, pIdx = 0;
		
		for(int i = 0; i < m; i++) {
			while(pIdx > 0 && str.charAt(i) != pattern.charAt(pIdx)) pIdx = lps[pIdx - 1];
			
			if(str.charAt(i) == pattern.charAt(pIdx)) {
				pIdx++;
				
				if(pIdx == pattern.length()) {
					cnt++;
					pIdx = lps[pIdx - 1];
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		System.out.print(kmpSearch(getPattern(n)));
	}
}