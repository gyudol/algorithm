import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	
	private static class Bus implements Comparable<Bus> {
		private int stop;
		private int cost;
		
		private Bus(int stop, int cost) {
			this.stop = stop;
			this.cost = cost;
		}
		
		public int compareTo(Bus other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	private static int dijkstra(int start, int end, ArrayList<ArrayList<Bus>> buses) {
		int [] costs = new int [n + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[start] = 0;
		
		PriorityQueue<Bus> minHeap = new PriorityQueue<>();
		minHeap.offer(new Bus(start, 0));
		
		while(!minHeap.isEmpty()) {
			Bus bus = minHeap.poll();
			
			if(bus.cost > costs[bus.stop]) continue;
			
			for(Bus nextBus : buses.get(bus.stop)) {
				int nextStop = nextBus.stop;
				int nextCost = costs[bus.stop] + nextBus.cost;
				
				if(costs[nextStop] > nextCost) {
					costs[nextStop] = nextCost;
					minHeap.offer(new Bus(nextStop, nextCost));
				}
			}
		}
		
		return costs[end];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Bus>> buses = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) buses.add(new ArrayList<>());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken()),
					cost = Integer.parseInt(st.nextToken());
			
			buses.get(src).add(new Bus(des, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
		
		System.out.print(dijkstra(start, end, buses));
	}
}