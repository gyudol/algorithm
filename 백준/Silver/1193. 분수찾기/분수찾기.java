import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		int end = 1, line = 1;
		
		while(end < x) end += ++line;
		
		int child = line % 2 == 0 ? line : 1;
		int parent = line % 2 == 0 ? 1 : line;	// end는 짝수일 때 왼쪽 끝, 홀수일 때 오른쪽 끝
		int offsetC = line % 2 == 0 ? -1 : 1;	// n번째 대각선에서 n이 홀수면 왼쪽에서, 짝수면 오른쪽에서 시작 
		int offsetP = line % 2 == 0 ? 1 : -1;
		
		int offset = end - x;
		parent += offsetP * offset;
		child += offsetC * offset;
		
		result.append(child).append('/').append(parent);
		
		System.out.print(result);
	}
}