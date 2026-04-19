class Solution {
    public int minPathSum(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // start from bottom-right
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){

                // base case (destination)
                if(i == m-1 && j == n-1){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i + 1 < m){
                    down = dp[i+1][j];
                }

                if(j + 1 < n){
                    right = dp[i][j+1];
                }

                dp[i][j] = grid[i][j] + Math.min(down, right);
            }
        }

        return dp[0][0];
    
    }
}