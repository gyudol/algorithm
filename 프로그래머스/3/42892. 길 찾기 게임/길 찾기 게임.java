import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
    
    void preorder(Node node, List<Integer> process) {
        if (node == null) return;
        
        process.add(node.num);
        preorder(node.left, process);
        preorder(node.right, process);
    }
    
    void postorder(Node node, List<Integer> process) {
        if (node == null) return;
        
        postorder(node.left, process);
        postorder(node.right, process);
        process.add(node.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes);
        Node root = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        
        preorder(root, preorder);
        postorder(root, postorder);
        
        return new int[][] {
            preorder.stream().mapToInt(Integer::intValue).toArray(),
            postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
    
    class Node implements Comparable<Node> {
        int num, x, y;
        Node left, right;
        
        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(other.y, y);
        }
    }
}