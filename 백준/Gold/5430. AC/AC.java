import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static class AC {
		private boolean isReversed = false;
		private Deque<Integer> deque = new ArrayDeque<>();
		
		private void offer(int num) {
			deque.offerLast(num);
		}
		
		private void reverse() {
			isReversed = !isReversed;
		}
		
		private boolean delete() {
			if(deque.size() == 0) return false;
			
			if(isReversed) deque.pollLast();
			else deque.pollFirst();
			
			return true;
		}
		
		private int size() {
			return deque.size();
		}
		
		private int get() {
			if(isReversed) return deque.pollLast();
			return deque.pollFirst();
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			char [] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			AC ac = new AC();
			boolean error = false;
			
			for(int i = 0; i < n; i++) ac.offer(Integer.parseInt(st.nextToken()));
			
			for(char order : p) {
				if(order == 'R') ac.reverse();
				else if(!ac.delete()) {
						error = true;
						break;
				}
			}
			
			if(error) result.append('e').append('r').append('r').append('o').append('r').append('\n');
			else {
				result.append('[');
				while(ac.size() > 1) result.append(ac.get()).append(',');
				if(ac.size() > 0) result.append(ac.get());	// ac가 빈 case도 있음
				result.append(']').append('\n');
			}
		}
		
		System.out.print(result);
	}
}