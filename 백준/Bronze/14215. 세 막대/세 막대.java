import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 3;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] tri = new int [LEN];
		
		for(int i = 0; i < LEN; i++) tri[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(tri);
		
		if(tri[2] >= tri[0] + tri[1]) tri[2] = tri[0] + tri[1] - 1;
		
		System.out.print(tri[0] + tri[1] + tri[2]);
	}
}
