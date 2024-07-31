import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static class Person {
		private Person parent = null;
		
		private Person root() {
			if(parent == null) return this;
			return parent = parent.root();
		}
		
		private boolean isConnected(Person p) {
			return root() == p.root();
		}
		
		private void merge(Person p) {
			if(isConnected(p)) return;
			p.root().parent = this;
		}
	}
	
	private static int lyingParty(int lastTruePerson, Person [] people, List<int []> parties) {
		if(lastTruePerson == -1) return parties.size();	// truthCnt == 0
		
		int cnt = 0;
		
		for(int [] party : parties) {
			int lying = 0;
			
			for(int person : party) {
				if(people[lastTruePerson].isConnected(people[person])) break;
				lying++;
			}
			
			if(lying == party.length) cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Person [] people = new Person [n + 1];
		int truthCnt = Integer.parseInt(st.nextToken());
		int lastTruePerson = -1;
		List<int []> parties = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) people[i] = new Person();
		
		for(int i = 0; i < truthCnt; i++) {
			int truePerson = Integer.parseInt(st.nextToken());
			
			if(lastTruePerson != -1) people[truePerson].merge(people[lastTruePerson]);
			lastTruePerson = truePerson;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int peopleCnt = Integer.parseInt(st.nextToken());
			int [] party = new int [peopleCnt];
			int lastPerson = -1;
			
			for(int j = 0; j < peopleCnt; j++) {
				party[j] = Integer.parseInt(st.nextToken());
				
				if(lastPerson != -1) people[lastPerson].merge(people[party[j]]);
				lastPerson = party[j];
			}
			
			parties.add(party);
		}
		
		System.out.print(lyingParty(lastTruePerson, people, parties));	
	}
}