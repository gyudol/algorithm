import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 8;
	private static final int [] ASC_SCALE = {1, 2, 3, 4, 5, 6, 7, 8};
	
	private static String perform(int [] scale) {
		int ascCnt = 0, desCnt = 0;
		
		for(int i = 0; i < LEN; i++) {
			if(scale[i] == ASC_SCALE[i]) ascCnt++;
			if(scale[i] == ASC_SCALE[LEN - 1 - i]) desCnt++;
		}
		
		return ascCnt == LEN ? "ascending" : desCnt == LEN ? "descending" : "mixed";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] scale = new int [LEN];
		
		for(int i = 0; i < LEN; i++) scale[i] = Integer.parseInt(st.nextToken());
		
		System.out.print(perform(scale));
	}
}