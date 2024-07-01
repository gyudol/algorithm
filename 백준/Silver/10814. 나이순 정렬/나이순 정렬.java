import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static class Member implements Comparable<Member> {
		public int age;
		public String name;
		
		private Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member other) {
			return Integer.compare(age, other.age);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Member [] members = new Member [n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(members);
		
		for(Member m : members) 
			result.append(m.age).append(' ').append(m.name).append('\n');
		
		System.out.print(result);
	}
}