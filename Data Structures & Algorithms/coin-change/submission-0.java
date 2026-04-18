class Solution {
    public int coinChange(int[] coins, int amount) {
        //fill with infinity when ther is min ways or max ways or max paths 
        //fill with boolean when it asks no of ways or anythng elsse
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        //fill the dp array with infinity
        for(int i=0; i< n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //fill the amount 0
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int target=0;target<=amount;target++){
            if(target%coins[0]==0)
            dp[0][target]=target/coins[0];
        }
        //fill in the dp table
        for(int i=1;i<n;i++){
            for(int target=1;target<=amount;target++){
                int nottake=0+dp[i-1][target];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=target && dp[i][target-coins[i]]!=Integer.MAX_VALUE){
                    take=1+dp[i][target-coins[i]];
                }
                dp[i][target]=Math.min(take,nottake);
            }
        }
        //if the answer still has max val return -1
       int answer=dp[n-1][amount];
       return answer==Integer.MAX_VALUE ?-1:answer;
    }
}
