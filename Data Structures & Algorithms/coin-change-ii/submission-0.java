class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        //here we just want no of ways so go and fill dp table only
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int target=0;target<=amount;target++){
            if(target%coins[0]==0){
                dp[0][target]=1;
            }
        }
        //fill in the dp table
        for(int i=1;i<n;i++){
            for(int target=1;target<=amount;target++){
                int nottake=dp[i-1][target];
                int take=0;
                if(coins[i]<=target){
                    take=dp[i][target-coins[i]];
                }
                dp[i][target]=take+nottake;
            }
        }
        return dp[n-1][amount];

    }
}
