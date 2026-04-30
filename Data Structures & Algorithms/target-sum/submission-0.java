class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total=0;
        for(int num: nums){
            total+=num;
        }
        // math trick: sum(P) = (totalSum + target) / 2
        if((total+target)%2!=0) return 0;
        
        if (Math.abs(target) > total) return 0;

        int targetsum=(total+target)/2;
        
        int[][] dp=new int[n][targetsum+1];

        // base case: amount 0 → 1 way (pick nothing)
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        // row 0: only nums[0] available
        if (nums[0] <= targetsum) {
            dp[0][nums[0]] += 1;  // += because nums[0] could be 0
        }
        for(int i=1;i<n;i++){
            for(int target2=0;target2<=targetsum;target2++){
                int take=0;
                int nottake=dp[i-1][target2];
                if(nums[i]<=target2){
                    take=dp[i-1][target2-nums[i]];
                }
                dp[i][target2]=take+nottake;
            }
        }
        return dp[n-1][targetsum];
    }
}
