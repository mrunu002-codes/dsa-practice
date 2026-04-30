class Solution {
    public int combinationSum4(int[] nums, int target) {
        //love babbar solution
        //long book end dry run
        int n=nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int tar=1;tar<=target;tar++){
            //iterate over the nums for getting the permuations
            for(int i=0;i<n;i++){
                if(tar-nums[i]>=0){
                    dp[tar]+=dp[tar-nums[i]];
                }
               
            }
        }
        return dp[target];
    }
}