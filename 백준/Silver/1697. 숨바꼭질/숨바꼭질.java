import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 100000;
	
	private static class State {
		public final int x;
		public final int depth;
		
		private State(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}
	}
	
	private static int bfs(int start, int target) {
		Queue<State> q = new LinkedList<>();
		boolean [] isVisited = new boolean [MAX + 1];
		q.offer(new State(start, 0));
		isVisited[start] = true;
		
		while(!q.isEmpty()) {
			State state = q.poll();
			
			if(state.x == target) return state.depth;
			
			if(state.x > 0 && !isVisited[state.x - 1]) {
				q.offer(new State(state.x - 1, state.depth + 1));
				isVisited[state.x - 1] = true;
			}
			if(state.x < MAX && !isVisited[state.x + 1]) {
				q.offer(new State(state.x + 1, state.depth + 1));
				isVisited[state.x + 1] = true;
			}
			if(state.x <= MAX / 2 && !isVisited[state.x * 2]) {
				q.offer(new State(state.x * 2, state.depth + 1));
				isVisited[state.x + 1] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()), target = Integer.parseInt(st.nextToken());
		
		System.out.print(bfs(start, target));
	}
}