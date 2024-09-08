import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static class Node {
		private Map<Character, Node> children = new HashMap<>();
		
		private void add(String phone, int offset) {
			if(offset < phone.length()) {
				char c = phone.charAt(offset);
				Node child = children.getOrDefault(c, new Node());
				
				child.add(phone, offset + 1);
				children.put(c, child);
			}
		}
		
		private boolean isConsistent(String phone, int depth) {
			char c = phone.charAt(depth);
			
			if(depth == phone.length() - 1) {
				if(children.get(c).children.size() == 0) return true;
				return false;
			}
			
			return children.get(c).isConsistent(phone, depth + 1);
		}
	}
	
	private static boolean isConsistent(Node trie, String[] phones, int maxLen) {
		for(String phone : phones) {
			if(phone.length() == maxLen) continue;	// 전화번호 같은 경우 없으므로 가장 긴 전화번호들은 건너뜀
			if(!trie.isConsistent(phone, 0)) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			Node trie = new Node();
			String[] phones = new String[N];
			int maxLen = 0;
			
			for(int i = 0; i < N; i++) {
				phones[i] = br.readLine();
				
				trie.add(phones[i], 0);
				maxLen = Math.max(maxLen, phones[i].length());
			}
			
			if(isConsistent(trie, phones, maxLen)) result.append('Y').append('E').append('S').append('\n');
			else result.append('N').append('O').append('\n');
		}
		
		System.out.print(result);
	}
}