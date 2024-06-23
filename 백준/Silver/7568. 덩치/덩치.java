import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class Person {
		public final int w;
		public final int h;
		
		private Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		Person [] people = new Person [N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			Person p1 = people[i];
			int cnt = 0;
			
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				Person p2 = people[j];
				if(p2.w > p1.w && p2.h > p1.h) cnt++;
			}
			
			result.append(cnt + 1).append(' ');
		}
		
		System.out.print(result);
	}
}