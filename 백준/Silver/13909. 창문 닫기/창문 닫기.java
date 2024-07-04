import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 1; i * i <= N; i++) {	// 제곱 수인 경우 약수가 홀수이므로 열림
			cnt++;
		}
		
		System.out.print(cnt);
	}
}