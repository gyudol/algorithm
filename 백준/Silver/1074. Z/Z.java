import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int depth;
	
	private static void compress(int row, int col, int size) {
		if(size == 1) return;
		
		int half = size / 2;
		
		if(row < half && col < half) compress(row, col, half);
		else {
			int halfPow = half * half;
			
			if(row < half && col >= half) depth += halfPow;
			if(row >= half && col < half) depth += halfPow * 2;
			if(row >= half && col >= half) depth += halfPow * 3;
			
			compress(row % half, col % half, half);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		depth = 0;
		
		compress(r, c, (int) Math.pow(2, N));
		
		System.out.print(depth);
	}
}