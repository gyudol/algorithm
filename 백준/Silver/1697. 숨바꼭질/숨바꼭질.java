import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	static final int MAX = 100_000;
	
	static class State {
		int x, sec;
		
		State(int x, int sec) {
			this.x = x;
			this.sec = sec;
		}
	}
	
	static int hideAndSeek(int N, int K) {
		if (N >= K) return N - K;
		
		Queue<State> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[MAX + 1];
		
		q.offer(new State(N, 0));
		isVisited[N] = true;
		
		while (!q.isEmpty()) {
			State state = q.poll();
			int x = state.x, sec = state.sec;
			
			if (x == K) return sec;
			
			for (int des : new int[] {x - 1, x + 1, x * 2}) {
				if (des < 0 || des > MAX || isVisited[des]) continue;
				isVisited[des] = true;
				
				q.offer(new State(des, sec + 1));
			}
		}
		
		return -1;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String [] args) throws Exception {
		final int N = readInt(), K = readInt();
		
		System.out.print(hideAndSeek(N, K));
	}
}