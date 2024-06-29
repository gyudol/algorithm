import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
				v = Integer.parseInt(st.nextToken());
		int target = v - a;	// 마지막 날 제외 (v - a >= 0)
		
		System.out.print((int) Math.ceil(target * 1.0 / (a - b)) + 1);
	}
}