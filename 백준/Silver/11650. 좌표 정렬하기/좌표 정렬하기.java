import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int [][] coord = new int [n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < coord[i].length; j++) 
				coord[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coord, (c1, c2) -> {
			if(c1[0] == c2[0]) return Integer.compare(c1[1], c2[1]);
			return Integer.compare(c1[0], c2[0]);
		});
		
		for(int [] c : coord) result.append(c[0]).append(' ').append(c[1]).append('\n');
		
		System.out.print(result);
	}
}