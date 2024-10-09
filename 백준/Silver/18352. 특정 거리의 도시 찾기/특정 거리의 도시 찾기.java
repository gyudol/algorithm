import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	private static int N, K, X;
	private static ArrayList<ArrayList<Integer>> roads;
	
	private static List<Integer> bfs() {
		Queue<Integer> cities = new LinkedList<>();
		int[] dist = new int[N + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		for(int des : roads.get(X)) {
			cities.offer(des);
			dist[des] = 1;
		}
		
		while(!cities.isEmpty()) {
			int src = cities.poll();
			
			if(dist[src] + 1 > K) break;
			
			for(int des : roads.get(src)) {
				if(dist[des] <= dist[src] + 1) continue;
				
				cities.offer(des);
				dist[des] = dist[src] + 1;
			}	
		}
		
		return IntStream.range(1, dist.length)
				.filter(i -> dist[i] == K).boxed().collect(Collectors.toList());
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken());
		roads = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) roads.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			roads.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> kList = bfs();
		
		if(kList.isEmpty()) result.append(-1);
		else {
			for(int d : kList) result.append(d).append('\n');
		}
		
		System.out.print(result);
	}
}