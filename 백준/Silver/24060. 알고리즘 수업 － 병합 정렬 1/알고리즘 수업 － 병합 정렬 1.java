import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int saveCnt = 0;
	private static int K;
	private static int res = -1;
	private static int [] tmp;		// 전역변수로 지정하지 않으면 매번 초기화해야 하므로 시간 초과
	
	private static void merge(int [] A, int p, int q, int r) {
		int i = p, j = q + 1, t = 0;
		
		while(i <= q && j <= r) {
			if(A[i] <= A[j]) tmp[t++] = A[i++];
			else tmp[t++] = A[j++];
		}
		
		while(i <= q) tmp[t++] = A[i++];	// 왼쪽 배열 부분이 남은 경우
		while(j <= r) tmp[t++] = A[j++];	// 오른쪽 배열 부분이 남은 경우
		
		i = p;	t = 0;
		while(i <= r) {
			if(++saveCnt == K) {
				res = tmp[t];
				return;
			}
			A[i++] = tmp[t++];	// 결과를 저장
		}
	}
	
	private static void merge_sort(int [] A, int p, int r) {
		if(saveCnt >= K) return;
		
		if(p < r) {
			int q = (p + r) / 2;		// q는 p, r의 중간 지점
			merge_sort(A, p, q);		// 전반부 정렬
			merge_sort(A, q + 1, r);	// 후반부 정렬
			merge(A, p, q, r);			// 병합
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		int [] A = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		tmp = new int [N];
		
		merge_sort(A, 0, N - 1);
		System.out.print(res);
	}
}