import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int min;
	static Axis src, des;
	static Axis[] clients;
	
	static class Axis {
		int x, y;
		
		Axis(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int distance(int curX, int curY, Axis other) {
		return Math.abs(curX - other.x) + Math.abs(curY - other.y);
	}
	
	static void permutation(int depth, int curX, int curY, int sum, boolean[] isVisited) {
		if(sum >= min) return;
		if(depth == N) {
			min = Math.min(sum + distance(curX, curY, des), min);
			return;
		}
		
		for(int v = 0; v < N; v++) {
			if(isVisited[v]) continue;
			
			isVisited[v] = true;
			permutation(depth + 1, clients[v].x, clients[v].y,
					sum + distance(curX, curY, clients[v]), isVisited);
			isVisited[v] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			clients = new Axis[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			src = new Axis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			des = new Axis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i < N; i++)
				clients[i] = new Axis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			permutation(0, src.x, src.y, 0, new boolean[N]);
			result.append('#').append(tc).append(' ').append(min).append('\n');
		}
	
		System.out.print(result);
	}
}