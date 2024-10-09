import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	private static int N;
	private static int K;
	private static int X;
	private static ArrayList<ArrayList<Integer>> roads;
	
	private static class Road implements Comparable<Road> {
		private int des;
		private int cost;
		
		private Road(int des, int cost) {
			this.des = des;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road other) {
			return Integer.compare(cost, other.cost);
		}
	}
	
	private static List<Integer> dijkstra() {
		PriorityQueue<Road> minHeap = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		for(int des : roads.get(X)) minHeap.offer(new Road(des, 1));
		
		while(!minHeap.isEmpty()) {
			Road road = minHeap.poll();
			int src = road.des, cost = road.cost;
			
			if(cost > dist[src]) continue;
			dist[src] = cost;
			
			for(int des : roads.get(src)) {
				if(cost + 1 < dist[des]) minHeap.offer(new Road(des, cost + 1));
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
		
		List<Integer> kList = dijkstra();
		
		if(kList.isEmpty()) result.append(-1);
		else {
			for(int d : kList) result.append(d).append('\n');
		}
		
		System.out.print(result);
	}
}