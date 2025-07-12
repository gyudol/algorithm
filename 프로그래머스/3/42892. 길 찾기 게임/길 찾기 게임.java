import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public class Node {
        public final int x;
        public final int y;
        public final int value;
        
        public Node left;
        public Node right;
        
        private Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
    private void insertNode(Node root, Node node) {
        if(node.x < root.x) {
            if(root.left == null) root.left = node;
            else insertNode(root.left, node);
        }
        else {
            if(root.right == null) root.right = node;
            else insertNode(root.right, node);
        }
    }
    
    private void pre(Node node, List<Integer> preorder) {
        if(node == null) return;
        
        preorder.add(node.value);
        
        pre(node.left, preorder);
        pre(node.right, preorder);
    }
    
    private void post(Node node, List<Integer> postorder) {
        if(node == null) return;
        
        post(node.left, postorder);
        post(node.right, postorder);
        
        postorder.add(node.value);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node [] nodes = new Node [nodeinfo.length];
        
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.y - n1.y;
            }
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }
        
        List<Integer> preorder = new ArrayList<>();
        pre(root, preorder);
        
        List<Integer> postorder = new ArrayList<>();
        post(root, postorder);
        
        return new int [][] {
            preorder.stream().mapToInt(Integer::intValue).toArray(),
            postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
}