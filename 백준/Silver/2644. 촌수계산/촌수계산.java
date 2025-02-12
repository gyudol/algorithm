import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static ArrayList<ArrayList<Integer>> edges;
	
	private static class State {
		int person, dist;
		
		public State(int person, int dist) {
			this.person = person;
			this.dist = dist;
		}
	}
	
	private static int bfs(int src, int des) {
		Queue<State> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N + 1];
		
		q.offer(new State(src, 0));
		isVisited[src] = true;
		
		while(!q.isEmpty()) {
			State state = q.poll();
			int u = state.person, dist = state.dist;
			
			if(u == des) return dist;
			
			for(int v : edges.get(u)) {
				if(isVisited[v]) continue;
				isVisited[v] = true;
				
				q.offer(new State(v, dist + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(br.readLine());
		
		edges = new ArrayList<>();
		for(int i = 0; i <= N; i++) edges.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
			
			edges.get(parent).add(child);
			edges.get(child).add(parent);
		}
		
		System.out.print(bfs(src, des));
	}
}