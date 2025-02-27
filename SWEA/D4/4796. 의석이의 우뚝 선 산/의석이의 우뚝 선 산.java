class Solution {
    static int getIntervalCount(int N, int[] heights) {
        int cnt = 0, src = 0, mid = 0, des = 1;
         
        while(des < N - 1) {
            while(des < N && (heights[des - 1] < heights[des])) mid = des++;
            while(des < N && (heights[des - 1] > heights[des])) des++;
 
            cnt += (mid - src) * (des - mid - 1);
            src = mid = des - 1;
        }
         
        return cnt;
    }
    
    static int readInt() throws Exception {
    	int c, n = System.in.read() & 15;
    	
    	while((c = System.in.read()) >= 48) 
    		n = (n << 3) + (n << 1) + (c & 15);
    	if(c == 13) System.in.read();
    	
    	return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        final int T = readInt();
         
        for(int tc = 1; tc <= T; tc++) {
            final int N = readInt();
            int[] heights = new int[N];
            
            for(int i = 0; i < N; i++) heights[i] = readInt();
             
            result.append('#').append(tc).append(' ')
                .append(getIntervalCount(N, heights)).append('\n');
        }
         
        System.out.print(result);
    }
}