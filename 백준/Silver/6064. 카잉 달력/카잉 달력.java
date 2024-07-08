import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int khaingYear(int endX, int endY, int targetX, int targetY) {
		int x = 0, y = 0;
		int year = 0;
		
		while(x != endX || y != endY) {
			int offsetX = endX - x == 0 ? endX : endX - x;
			int offsetY = endY - y == 0 ? endY : endY - y;
			int minOffset = offsetX <= offsetY ? offsetX : offsetY;
			
			x = (x + minOffset - 1) % endX + 1;
			y = (y + minOffset - 1) % endY + 1;
			year += minOffset;
			
			if(y - x == targetY - targetX) {
				return year + (targetY - y);
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken()), endY = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			
			result.append(khaingYear(endX, endY, x, y)).append('\n');
		}
		
		System.out.print(result);
	}
}