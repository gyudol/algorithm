import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static final char [] SYMBOLS = {'+', '-', '*', '/'};
	private static int n;
	
	private static void buildOperatorSet(Set<String> operatorSet, String prefix, int [] items) {
		if(prefix.length() == n - 1) {
			operatorSet.add(prefix);
			return;
		}
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] == 0) continue;
			
			items[i]--;
			buildOperatorSet(operatorSet, prefix + SYMBOLS[i], items);
			items[i]++;
		}
	}
	
	private static int calculate(int a, char operator, int b) {
		int value = -1;
		
		switch(operator) {
			case '+': value = a + b;	break;
			case '-': value = a - b;	break;
			case '*': value = a * b;	break;
			case '/': value = a / b;	break;
		}
		
		return value;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] a = new int [n];
		int [] items = new int [SYMBOLS.length];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length; i++) a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < items.length; i++) items[i] = Integer.parseInt(st.nextToken());
		
		Set<String> operatorSet = new HashSet<>();
		buildOperatorSet(operatorSet, "", items);
		
		for(String operators : operatorSet) {
			int value = a[0];
			
			for(int i = 1; i < n; i++) value = calculate(value, operators.charAt(i - 1), a[i]);
			
			if(value < min) min = value;
			if(value > max) max = value;
		}
		
		result.append(max).append('\n').append(min);
		
		System.out.print(result);
	}
}