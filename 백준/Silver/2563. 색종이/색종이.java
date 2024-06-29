import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 10;
	private static final int MAX = 100;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean [][] square = new boolean [MAX][MAX];
		int n = Integer.parseInt(br.readLine());
		int area = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int srcX = Integer.parseInt(st.nextToken());
			int srcY = Integer.parseInt(st.nextToken());
			
			for(int x = srcX; x < srcX + LEN; x++) {
				for(int y = srcY; y < srcY + LEN; y++) square[y][x] = true;
			}
		}
		
		for(boolean [] row : square) {
			for(boolean isAttached : row) {
				if(isAttached) area++;
			}
		}
		
		System.out.print(area);
	}
}