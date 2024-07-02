import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 100000;
	
	private static class State {
		public int x;
		public int time;
		
		private State(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	private static int bfs(int n, int k, boolean [] isVisited) {
		PriorityQueue<State> pq = 
				new PriorityQueue<>((s1, s2) -> Integer.compare(s1.time, s2.time));
		pq.offer(new State(n, 0));
		
		while(!pq.isEmpty()) {
			State s = pq.poll();
			
			if(s.x == k) return s.time;
			isVisited[s.x] = true;	// 큐 내부에서 순서가 바뀌므로 값을 뽑아낸 뒤 방문 처리
			
			if(s.x <= MAX / 2 && s.x < k && !isVisited[s.x * 2]) pq.offer(new State(s.x * 2, s.time));
			if(s.x > 0 && !isVisited[s.x - 1]) pq.offer(new State(s.x - 1, s.time + 1));
			if(s.x < MAX && !isVisited[s.x + 1]) pq.offer(new State(s.x + 1, s.time + 1));
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		
		System.out.print(bfs(n, k, new boolean [MAX + 1]));
	}
}