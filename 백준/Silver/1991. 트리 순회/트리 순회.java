import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final char STD = 'A';
	private static StringBuilder result;
	private static Node [] tree;
	
	private static class Node {
		private char value;
		private int left;
		private int right;
		
		private Node(char value, char left, char right) {
			this.value = value;
			this.left = left == '.' ? -1 : left - STD;
			this.right = right == '.' ? -1 : right - STD;
		}
	}
	
	private static void preorder(int src) {
		if(src == -1) return;
		
		result.append(tree[src].value);
		preorder(tree[src].left);
		preorder(tree[src].right);
	}
	
	private static void inorder(int src) {
		if(src == -1) return;
		
		inorder(tree[src].left);
		result.append(tree[src].value);
		inorder(tree[src].right);
	}
	
	private static void postorder(int src) {
		if(src == -1) return;
		
		postorder(tree[src].left);
		postorder(tree[src].right);
		result.append(tree[src].value);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		tree = new Node [n];
		
		for(int i = 0; i < n; i++) {
			String edges = br.readLine();
			int parent = edges.charAt(0) - STD;
			
			tree[parent] = new Node(edges.charAt(0), edges.charAt(2), edges.charAt(4));
		}
		
		preorder(0);	result.append('\n');
		inorder(0);		result.append('\n');
		postorder(0);
		
		System.out.print(result);
	}
}