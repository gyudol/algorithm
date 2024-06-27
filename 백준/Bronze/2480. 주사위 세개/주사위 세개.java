import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int reward(int [] d) {
		if(d[0] == d[1] && d[1] == d[2]) return 10000 + 1000 * d[0];
		if(d[0] == d[1] || d[0] == d[2]) return 1000 + 100 * d[0];
		if(d[1] == d[2]) return 1000 + 100 * d[1];
		
		int max = Integer.MIN_VALUE;
		for(int dice : d) {
			if(dice > max) max = dice;
		}
		
		return 100 * max;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] dices = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		System.out.print(reward(dices));
	}
}