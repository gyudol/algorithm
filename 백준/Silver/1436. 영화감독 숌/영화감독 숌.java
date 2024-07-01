import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int FIND = 666;
	
	private static int makeTitle(int n) {
		int src = FIND - 1, cnt = 0;
		
		while(cnt < n) {
			int tmp = ++src;
			
			while(tmp >= FIND) {
				if(tmp % 1000 == FIND) {	// FIND가 중앙에 있는 Case
					cnt++;
					break;
				}

				tmp /= 10;
			}
		}
		
		return src;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(makeTitle(n));
	}
}