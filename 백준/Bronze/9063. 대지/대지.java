import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			
			minX = Math.min(x, minX);
			maxX = Math.max(x, maxX);
			minY = Math.min(y, minY);
			maxY = Math.max(y, maxY);
		}
		
		System.out.print((maxX - minX) * (maxY - minY));
	}
}