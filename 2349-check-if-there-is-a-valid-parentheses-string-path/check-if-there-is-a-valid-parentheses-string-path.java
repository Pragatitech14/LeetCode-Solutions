class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int len = m + n - 1;

        // Valid parentheses string must have even length
        if (len % 2 != 0) {
            return false;
        }

        // Starting cell must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][len + 1];

        // Start with balance = 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int change;

                if (grid[i][j] == '(') {
                    change = 1;
                } else {
                    change = -1;
                }

                for (int balance = 0; balance <= len; balance++) {

                    int prevBalance = balance - change;

                    if (prevBalance < 0 || prevBalance > len) {
                        continue;
                    }

                    // Come from top
                    if (i > 0 && dp[i - 1][j][prevBalance]) {
                        dp[i][j][balance] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][prevBalance]) {
                        dp[i][j][balance] = true;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}