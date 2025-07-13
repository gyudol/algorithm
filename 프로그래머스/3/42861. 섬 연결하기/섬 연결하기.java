import java.util.Arrays;

class Solution {
    int[] parents;
    
    int findRoot(int node) {
        if (parents[node] == node) return node;
        return parents[node] = findRoot(parents[node]);
    }
    
    boolean merge(int nodeA, int nodeO) {
        int rootA = findRoot(nodeA), rootO = findRoot(nodeO);
        
        if (rootA == rootO) return false;
        
        parents[rootO] = rootA;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[2], c2[2]));
        int minCost = 0;
        
        for (int[] edge : costs) {
            if (merge(edge[0], edge[1])) minCost += edge[2];
        }
        
        return minCost;
    }
}