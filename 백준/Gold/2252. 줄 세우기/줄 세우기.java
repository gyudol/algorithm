import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	
	private static StringBuilder topologicalSort(int N, int[] indegree) {
		StringBuilder result = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int curNode = q.poll();
			
			result.append(curNode).append(' ');
			
			for(int neighbor : graph.get(curNode)) {
				indegree[neighbor]--;
				if(indegree[neighbor] == 0) q.offer(neighbor);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		graph = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			indegree[v]++;
		}
		
		System.out.print(topologicalSort(N, indegree));
	}
}