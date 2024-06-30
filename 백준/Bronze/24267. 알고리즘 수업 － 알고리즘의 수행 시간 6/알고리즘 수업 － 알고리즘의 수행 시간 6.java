import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX_DEGREE = 3;
	/* sigma(i = 1 -> n - 2, sigma(j = i + 1 -> n - 1, sigma(k = j + 1 -> n, 1)))
		세 번째 루프: n - (j + 1) + 1 = k는 n - j 번 반복
		두 번째 루프: sigma(j = i + 1 -> n - 1, n - j)
			= (n - (i + 1)) + (n - (i + 2)) + ... + (n - (n - 1))
			= (n - i - 1) + (n - i - 2) + ... + 1
			= (n - i - 1)(n - i) / 2
		첫 번째 루프: sigma(i = 1 -> n - 2, (n - i - 1)(n - i) / 2)
			= 1 / 2 * sigma(i = 1 -> n - 2, (n - i - 1)(n - i))
			= 1 / 2 * sigma(i = 1 -> n - 2, n^2 - 2ni + i^2 - n + i) => 각 항 별로 시그마 분리 후 계산
			= 1 / 2 * ((n-2)n^2 - n(n-2)(n-1) + (n-2)(n-1)(2n-3)/6 - (n-2)n + (n-2)(n-1)/2)
			=> 정리 = n * (n - 1) * (n - 2) / 6												*/
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		result.append(n * (n - 1L) * (n - 2) / 6).append('\n').append(MAX_DEGREE);
		
		System.out.print(result);
	}
}