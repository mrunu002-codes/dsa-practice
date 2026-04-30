class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        if(n==0) return 0;
        if(n==1) return nums[0];
        //case 1: exclude the last 
        for(int i=0;i<n-1;i++){
            arr1[i]=nums[i];
        }
        //case 2: exclude first
        for(int i=0;i<n-1;i++){
            arr2[i]=nums[i+1];
        }
        return Math.max(helper(arr1),helper(arr2));
    }
    private int helper(int[] nums){
        if(nums.length==0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + dp[i - 2];
            int notpick =0+dp[i - 1];
            dp[i] = Math.max(notpick, pick);

        }
        return dp[nums.length-1];
    }
}
