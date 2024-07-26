import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 256;
	private static int [][] ground;
	private static int n;
	private static int m;
	
	private static int flatten(int height, int b) {
		int time = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int diff = ground[i][j] - height;
				b += diff;
				
				if(diff < 0) time += Math.abs(diff);	// place blocks
				else time += diff * 2;	// remove blocks and put in inventory
			}
		}
		
		return b < 0 ? -1 : time;	// b < 0: can't place
	}
	
	private static StringBuilder minecraft(int b) {
		StringBuilder result = new StringBuilder();
		int [] min = {Integer.MAX_VALUE, -1};
		
		for(int height = 0; height <= MAX; height++) {
			int time = flatten(height, b);

			if(time != -1 && time <= min[0]) {
				min[0] = time;
				min[1] = height;
			}
		}
		
		return result.append(min[0]).append(' ').append(min[1]);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ground = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) ground[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(minecraft(b));
	}
}