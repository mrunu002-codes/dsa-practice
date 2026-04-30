class Solution {
    public int search(int[] nums, int target) {
        //shareddha khapra video
        //apply binary search on left sorted or right sorted
        int n=nums.length;
        int start=0;
        int end=n-1;
        

        while(start<= end){

            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            //check if left half is sorted
            if(nums[start]<=nums[mid]){
                //check if targert lies in the left half and apply bs there 
                if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            //check if the right half is sorted
            else{
                //check if target lies in the right sorted half
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
