import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) list.add(Integer.parseInt(br.readLine()));
		Collections.sort(list);
		for(int num : list) result.append(num).append('\n');
		
		System.out.print(result);
	}
}