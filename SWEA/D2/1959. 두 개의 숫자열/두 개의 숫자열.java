import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];	// smaller
            int[] B = new int[M];	// bigger
        	int max = Integer.MIN_VALUE;
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < A.length; i++) A[i] = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < B.length; i++) B[i] = Integer.parseInt(st.nextToken());
        	
        	if(N > M) {	// swap
        		int[] tmp = A;
        		A = B;
        		B = tmp;
        	}
        	
        	for(int offset = 0; offset <= B.length - A.length; offset++) {
        		int sum = 0;
        		
        		for(int idx = 0; idx < A.length; idx++) sum += A[idx] * B[idx + offset];
        		max = Math.max(sum, max);
        	}
        	
        	result.append('#').append(tc).append(' ').append(max).append('\n');
        }
         
        System.out.print(result);
    }
}