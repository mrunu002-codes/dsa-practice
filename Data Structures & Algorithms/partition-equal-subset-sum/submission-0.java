class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        if(totalsum%2!=0){
            return false;
        }
        //sum of the subset
        int targetsum=totalsum/2;

        boolean[][] dp=new boolean[n][targetsum+1];

        // Base case: sum 0 is always possible
        for(int i=0; i< n; i++){
            dp[i][0]=true;
        }
        //fill first row with possible sum
        for(int i=0;i<n;i++){
            if(nums[0]<=targetsum){
                dp[0][nums[0]]=true;
            }
        }
        //fill in the dp table 
        for(int index=1;index<n;index++){
            for(int target=1;target<=targetsum;target++){
                boolean nottake=dp[index-1][target];
                boolean take=false;
                if(nums[index]<=target){
                    take=dp[index-1][target-nums[index]];
                }
                dp[index][target]= take || nottake;
            }
        }
        return dp[n-1][targetsum];

    }
}
