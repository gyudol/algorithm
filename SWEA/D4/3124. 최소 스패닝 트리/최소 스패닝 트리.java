import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
class Solution {
    static int V, E;
    static int[] parents;
    static List<Edge> edges;
     
    static int root(int node) {
        if (parents[node] == node) return node;
        return parents[node] = root(parents[node]);
    }
     
    static boolean merge(int u, int v) {
        int rootU = root(u), rootV = root(v);
         
        if (rootU == rootV) return false;
        parents[rootV] = rootU;
         
        return true;
    }
     
    static long kruskal() {
        long totalDist = 0;
        int vCnt = 1;
         
        Collections.sort(edges);
         
        for (Edge edge : edges) {
            if (!merge(edge.u, edge.v)) continue;
             
            totalDist += edge.dist;
            if (++vCnt == V) break;
        }
         
        return totalDist;
    }
     
    static int readInt() throws Exception {
        int c, n = 0;
         
        while ((c = System.in.read()) <= 32);
        boolean isNegative = c == 45;
         
        if (isNegative) c = System.in.read();
        do {
            n = (n << 3) + (n << 1) + (c & 15);
        } while ((c = System.in.read()) >= 48);
         
        return isNegative ? ~n + 1 : n;
    }
     
    public static void main(String[] args) throws Exception {
        final int T = readInt();
        StringBuilder result = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            V = readInt();
            E = readInt();
            parents = new int[V + 1];
            edges = new ArrayList<>();
             
            for (int node = 1; node <= V; node++) {
                parents[node] = node;
            }
             
            for (int i = 0; i < E; i++) {
                edges.add(new Edge(readInt(), readInt(), readInt()));
            }
             
            result.append('#').append(tc).append(' ')
                .append(kruskal()).append('\n');
        }
         
        System.out.print(result);
    }
     
    static class Edge implements Comparable<Edge> {
        int u, v, dist;
         
        Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
         
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(dist, other.dist);
        }
    }
}