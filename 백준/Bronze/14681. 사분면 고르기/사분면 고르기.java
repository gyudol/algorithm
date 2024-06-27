import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int quadrant(int x, int y) {
		if(x > 0 && y > 0) return 1;
		else if(x < 0 && y > 0) return 2;
		else if(x < 0 && y < 0) return 3;
		else return 4;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
		
		System.out.print(quadrant(x, y));
	}
}