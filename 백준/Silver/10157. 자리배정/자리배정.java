import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int C, R;
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static StringBuilder result;
	
	static void assignSeat(int target) {
		int curX = 1, curY = R, d = 1, state = R, offsetX = C - 1, offsetY = R - 1;
		
		if(target > R * C) {
			result.append(0);
			return;
		}
		
		while(state < target) {
			curX += offsetX * DIR[d][0];
			curY += offsetY * DIR[d][1];
			
			if(d % 2 == 0) state += offsetY--;
			else state += offsetX--;
			d = (d + 1) % DIR.length;
		}
		
		int diff = state - target;
        
		if(diff > 0) {
			state = target;
			d = (d - 1 + DIR.length) % DIR.length;
			curX -= diff * DIR[d][0];
			curY -= diff * DIR[d][1];
		}
		
		result.append(curX).append(' ').append(curY);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());	R = Integer.parseInt(st.nextToken());
		
		assignSeat(Integer.parseInt(br.readLine()));
		System.out.print(result);
	}
}