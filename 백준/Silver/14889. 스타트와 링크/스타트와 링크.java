import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int min;
	private static int [][] s;
	
	private static int startLink(boolean [] isVisited) {
		int startSum = 0, linkSum = 0;
		
		for(int i = 0; i < n; i++) {
			if(isVisited[i]) {
				for(int j = 0; j < n; j++) {
					if(isVisited[j]) startSum += s[i][j];
				}
			}
			else {
				for(int j = 0; j < n; j++) {
					if(!isVisited[j]) linkSum += s[i][j];
				}
			}	
		}
		
		return Math.abs(startSum - linkSum);
	}
	
	private static void comb(int src, int depth, boolean [] isVisited) {
		if(depth == n / 2) {
			min = Math.min(startLink(isVisited), min);
			return;
		}
		
		for(int i = src; i < n; i++) {
			if(isVisited[i]) continue;
			
			isVisited[i] = true;
			comb(i + 1, depth + 1, isVisited);
			isVisited[i] = false;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		s = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) s[i][j] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0, new boolean [n]);
		
		System.out.print(min);
	}
}