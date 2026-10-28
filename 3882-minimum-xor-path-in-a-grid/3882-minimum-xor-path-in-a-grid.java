
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int X = 1024;

        boolean[][] prev = new boolean[n][X];

        for (int i = 0; i < m; i++) {
            boolean[][] curr = new boolean[n][X];

            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                if (i == 0 && j == 0) {
                    curr[j][val] = true;
                    continue;
                }

                // Reach from above
                if (i > 0) {
                    for (int x = 0; x < X; x++) {
                        if (prev[j][x]) {
                            curr[j][x ^ val] = true;
                        }
                    }
                }

                // Reach from left
                if (j > 0) {
                    for (int x = 0; x < X; x++) {
                        if (curr[j - 1][x]) {
                            curr[j][x ^ val] = true;
                        }
                    }
                }
            }

            prev = curr;
        }

        for (int x = 0; x < X; x++) {
            if (prev[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
