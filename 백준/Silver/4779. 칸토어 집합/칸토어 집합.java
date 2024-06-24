import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Integer> list;
	
	private static void makeCantor(int src, int des) {		// [src, des)
		if(src == des - 1) {
			list.add(src);
			return;
		}
		
		makeCantor(src, src + (des - src) / 3);
		makeCantor(src + (des - src) / 3 * 2, des);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder result = new StringBuilder();
		
		while((line = br.readLine()) != null) {		// Ctrl + z로 종료
			int N = Integer.parseInt(line);
			int des = (int) Math.pow(3, N);
			list = new ArrayList<>();
			
			makeCantor(0, des);
			
			for(int i = 0; i < des; i++) {
				if(!list.isEmpty() && list.get(0) == i) {
					result.append('-');
					list.remove(0);
					continue;
				}
				
				result.append(' ');
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}