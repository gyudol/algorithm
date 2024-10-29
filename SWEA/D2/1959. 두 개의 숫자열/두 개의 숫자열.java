import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	private static int getMaxValue(int[] smaller, int[] bigger) {
		int max = Integer.MIN_VALUE;
		
		for(int offset = 0; offset <= bigger.length - smaller.length; offset++) {
    		int sum = 0;
    		
    		for(int idx = 0; idx < smaller.length; idx++) sum += smaller[idx] * bigger[idx + offset];
    		max = Math.max(sum, max);
    	}
		
		return max;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        	final int[] A = new int[N];
        	final int[] B = new int[M];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < A.length; i++) A[i] = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < B.length; i++) B[i] = Integer.parseInt(st.nextToken());
        	
        	result.append('#').append(tc).append(' ').append(N <= M ? getMaxValue(A, B) : getMaxValue(B, A)).append('\n');
        }
         
        System.out.print(result);
    }
}