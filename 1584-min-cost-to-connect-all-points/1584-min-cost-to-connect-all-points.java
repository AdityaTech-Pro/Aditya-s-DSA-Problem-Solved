class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[0] = 0;
        int ans = 0;

        for (int count = 0; count < n; count++) {

            // Find unvisited point with minimum cost
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!vis[i] && (u == -1 || minCost[i] < minCost[u])) {
                    u = i;
                }
            }

            // Add this point to MST
            vis[u] = true;
            ans += minCost[u];

            // Update minimum cost of remaining points
            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int distance = Math.abs(points[u][0] - points[v][0])
                                 + Math.abs(points[u][1] - points[v][1]);

                    minCost[v] = Math.min(minCost[v], distance);
                }
            }
        }

        return ans;
    }
}