import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class State {
		private long value;
		private int depth;
		
		private State(long value, int depth) {
			this.value = value;
			this.depth = depth;
		}
	}

	private static int bfs(int A, int B) {
		Queue<State> q = new LinkedList<>();
		q.offer(new State(A, 1));
		
		while(!q.isEmpty()) {
			State state = q.poll();
			long value = state.value;
			int depth = state.depth;
			
			if(value == B) return depth;
			
			long[] nextValues = new long[] {value * 2, value * 10 + 1};
			
			for(long nextValue : nextValues) {
				if(nextValue <= B) q.offer(new State(nextValue, depth + 1));
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		
		System.out.print(bfs(A, B));
	}
}