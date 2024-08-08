import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 50000001;
	private static int n;
	
	private static class Road {
		public int src;
		public int des;
		public int time;
		
		private Road(int src, int des, int time) {
			this.src = src;
			this.des = des;
			this.time = time;
		}
	}
	
	private static boolean bellmanFord(int start, List<Road> roads) {
		int [] costs = new int [n + 1];
		Arrays.fill(costs, INF);
		costs[start] = 0;
		
		for(int i = 1; i <= n; i++) {
			boolean updated = false;
			
			for(Road road : roads) {
				if(costs[road.src] != INF && costs[road.src] + road.time < costs[road.des]) {
					costs[road.des] = costs[road.src] + road.time;
					updated = true;
					
					// n - 1번 반복으로 최단 경로 구한 후, n번째 반복했을 때 값이 변경되면 음수 사이클 존재
					if(i == n) return true;
				}
			}
			
			if(!updated) return false;
		}
		
		return false;
	}
	
	private static boolean bellmanFord(List<Road> roads) {
		for(int start = 1; start <= n; start++) {
			if(bellmanFord(start, roads)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			List<Road> roads = new ArrayList<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()),
						t = Integer.parseInt(st.nextToken());
				
				roads.add(new Road(s, e, t));
				roads.add(new Road(e, s, t));
			}
			
			for(int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()),
						t = Integer.parseInt(st.nextToken());
				
				roads.add(new Road(s, e, t * -1));
			}
			
			if(bellmanFord(roads)) result.append('Y').append('E').append('S');
			else result.append('N').append('O');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}