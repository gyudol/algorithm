import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder result;
	
	private static class Node {
		private int key;
		private Node left;
		private Node right;
		
		private Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}
	
	private static void insertNode(Node parent, Node node) {
		if(node.key < parent.key) {
			if(parent.left == null) parent.left = node;
			else insertNode(parent.left, node);
		}
		else {
			if(parent.right == null) parent.right = node;
			else insertNode(parent.right, node);
		}
	}
	
	private static void postorder(Node node) {
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		result.append(node.key).append('\n');
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		while(true) {
			String line = br.readLine();
		
			if(line == null || line.isEmpty()) break;
			
			insertNode(root, new Node(Integer.parseInt(line)));
		}
		
		postorder(root);
		
		System.out.print(result);
	}
}