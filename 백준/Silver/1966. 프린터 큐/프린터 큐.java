import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static class Document {
		public final int prior;
		public final int order;
		
		private Document(int prior, int order) {
			this.prior = prior;
			this.order = order;
		}
	}
	
	private static boolean haveLargerThan(int prior, Set<Integer> priorSet) {
		for(int isLarger : priorSet) {
			if(isLarger > prior) return true;
		}
		
		return false;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Document> q = new LinkedList<>();
			Map<Integer, Integer> priorMap = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				Document doc = new Document(Integer.parseInt(st.nextToken()), i);
				q.offer(doc);
				priorMap.put(doc.prior, priorMap.getOrDefault(doc.prior, 0) + 1);
			}
			
			int cnt = 0, curOrder = -1;
			while(curOrder != M) {
				Document doc = q.poll();
				
				if(haveLargerThan(doc.prior, priorMap.keySet())) {
					q.offer(doc);
					continue;
				}
				
				curOrder = doc.order;
				priorMap.put(doc.prior, priorMap.get(doc.prior) - 1);
				if(priorMap.get(doc.prior) == 0) priorMap.remove(doc.prior);
				cnt++;
			}
			
			result.append(cnt).append('\n');	
		}
		
		System.out.print(result);
	}
}