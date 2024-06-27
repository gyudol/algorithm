import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static final int TARGET = 1;
	
	private static class State {
		public final int x;
		public final int depth;
		
		private State(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}
	}
	
	private static int bfs(int N) {
		Queue<State> q = new LinkedList<>();
		q.offer(new State(N, 0));
		
		while(!q.isEmpty()) {
			State state = q.poll();
			
			if(state.x == TARGET) return state.depth;
			
			for(int i = 3; i >= 2; i--) {
				if(state.x % i == 0) 
					q.offer(new State(state.x / i, state.depth + 1));
			}
			
			if(state.x > 1) q.offer(new State(state.x - 1, state.depth + 1));
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(bfs(N));
	}
}