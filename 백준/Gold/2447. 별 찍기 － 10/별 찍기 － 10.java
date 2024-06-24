import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static char [][] makeStars(char [][] stars, int N) {
		if(stars.length == N) return stars;
		
		int length = stars.length;
		char [][] nextStars = new char [length * 3][length * 3];
		int spaceSrc = length, spaceDes = length * 2;	// [spaceSrc, spaceDes)
		
		for(int i = 0; i < nextStars.length; i++) {
			for(int j = 0; j < nextStars.length; j++) {
				if(i >= spaceSrc && i < spaceDes && j >= spaceSrc && j < spaceDes) nextStars[i][j] = ' ';
				else nextStars[i][j] = stars[i % length][j % length];
			}
		}
		
		return makeStars(nextStars, N);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		char [][] stars = makeStars(new char [][] {{'*'}}, N);
		
		for(char [] row : stars) result.append(row).append('\n');
		
		System.out.print(result);
	}
}