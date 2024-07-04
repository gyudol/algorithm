import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static class Balloon {
		public int idx;
		public int offset;
		
		private Balloon(int idx, int offset) {
			this.idx = idx;
			this.offset = offset;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Balloon> balloons = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) 
			balloons.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
		
		while(balloons.size() > 1) {
			Balloon b = balloons.pollFirst();
			
			if(b.offset > 0) {
				for(int i = 0; i < b.offset - 1; i++) balloons.addLast(balloons.pollFirst());
			}
			else {
				for(int i = 0; i > b.offset; i--) balloons.addFirst(balloons.pollLast());
			}
			
			result.append(b.idx).append(' ');
		}
		result.append(balloons.poll().idx);
		
		System.out.print(result);
	}
}