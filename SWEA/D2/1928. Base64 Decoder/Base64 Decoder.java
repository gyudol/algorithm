import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int BIT = 8;
	private static final int BINARY = 2;
	private static final int MAX_EXP = 5;
	
	private static int decode(char c) {
		if(c >= 'A' && c <= 'Z') return c - 'A';
		if(c >= 'a' && c <= 'z') return c - 'a' + 26;
		if(c == '+') return 62;
		if(c == '/') return 63;
		return c - '0' + 52;
	}
	
	private static StringBuilder toBinary(int decimal) {	// sliced 6 bit
		StringBuilder binary = new StringBuilder();
		
		for(int exp = 0; exp <= MAX_EXP; exp++) {
			binary.append(decimal % BINARY);
			decimal /= BINARY;
		}
		
		return binary.reverse();
	}
	
	private static char toAscii(String binary) {	// sliced 8 bit
		int sum = 0;
		
		for(int exp = 0; exp < BIT; exp++) sum += (binary.charAt(BIT - exp - 1) - '0') * Math.pow(BINARY, exp);

		return (char) sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String encoded = br.readLine();
			StringBuilder binary = new StringBuilder();
			StringBuilder decoded = new StringBuilder();
			
			for(char c : encoded.toCharArray()) binary.append(toBinary(decode(c)));
			for(int src = 0; src < binary.length(); src += BIT) decoded.append(toAscii(binary.substring(src, src + BIT)));
			
			result.append('#').append(tc).append(' ').append(decoded).append('\n');
		}
		
		System.out.print(result);
	}
}