import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static String rsp(int A, int B) {
		if(A == 1) {
			if(B == 2) return "B";
			else return "A";
		}
		else if(A == 2) {
			if(B == 1) return "A";
			else return "B";
		}
		else {
			if(B == 1) return "B";
			else return "A";
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		
		System.out.print(rsp(A, B));
	}
}