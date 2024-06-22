import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int div2 = 0;
	private static int div5 = 0;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= N; i++) {		// 2*5의 배수여야 뒷자리에 0이 나옴
			int num = i;
			
			while(num % 2 == 0 || num % 5 == 0) {
				if(num % 2 == 0) {
					num /= 2;
					div2++;
				}
				if(num % 5 == 0) {
					num /= 5;
					div5++;
				}
			}
		}
		
		System.out.print(Math.min(div2, div5));
	}
}