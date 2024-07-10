import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final String EMPTY = "EMPTY";
	
	private static class DoublePriorityQueue {
		public PriorityQueue<Integer> maxPq;
		public PriorityQueue<Integer> minPq;
		public Map<Integer, Integer> terminal;
		
		private DoublePriorityQueue() {
			maxPq = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
			minPq = new PriorityQueue<>();
			terminal = new HashMap<>();
		}
		
		private void offer(int n) {
			maxPq.offer(n);
			minPq.offer(n);
			terminal.put(n, terminal.getOrDefault(n, 0) + 1);
		}
		
		private void delete(int n) {
			if(terminal.size() == 0) return;
			
			int deleted = n == 1 ? maxPq.poll() : minPq.poll();
			
			while(n == 1 && !terminal.containsKey(deleted)) deleted = maxPq.poll();
			while(n == -1 && !terminal.containsKey(deleted)) deleted = minPq.poll();
			
			terminal.put(deleted, terminal.get(deleted) - 1);
			if(terminal.get(deleted) == 0) {
				terminal.remove(deleted);
				while(n == 1 && !maxPq.isEmpty() && !terminal.containsKey(maxPq.peek())) maxPq.poll();
				while(n == -1 && !minPq.isEmpty() && !terminal.containsKey(minPq.peek())) minPq.poll();
			}
			
			if(terminal.size() == 0) {
				maxPq.clear();
				minPq.clear();
			}
		}
		
		private String remain() {
			if(terminal.size() == 0) return EMPTY;
			if(terminal.size() == 1) {
				int res = terminal.keySet().iterator().next();
				
				return new StringBuilder().append(res).append(' ').append(res).toString();
			}
			
			return new StringBuilder().append(maxPq.poll()).append(' ').append(minPq.poll()).toString();
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			DoublePriorityQueue dpq = new DoublePriorityQueue();
			int k = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				switch(st.nextToken()) {
					case "I": dpq.offer(Integer.parseInt(st.nextToken())); break;
					case "D": dpq.delete(Integer.parseInt(st.nextToken())); break;
				}
			}
			
			result.append(dpq.remain()).append('\n');
		}
		
		System.out.print(result);
	}
}