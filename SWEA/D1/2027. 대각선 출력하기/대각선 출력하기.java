public class Solution {
	private static final int LEN = 5;
	
	public static void main(String [] args) throws Exception {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < LEN; i++) {
			for(int j = 0; j < LEN; j++) {
				if(i == j) result.append('#');
				else result.append('+');
			}
			result.append('\n');
		}
		
		System.out.print(result);
	}
}