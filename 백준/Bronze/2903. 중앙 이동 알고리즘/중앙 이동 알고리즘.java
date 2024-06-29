import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int edgePoint = 2;
		
		for(int i = 1; i <= n; i++) {
			edgePoint += (edgePoint - 1);
		}
		
		System.out.print(edgePoint * edgePoint);
	}
}