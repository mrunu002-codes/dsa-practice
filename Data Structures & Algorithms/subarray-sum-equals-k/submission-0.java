class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int presum=0;

        HashMap<Integer, Integer> map = new HashMap<>();
        //always keep in mind to add this first 
        map.put(0,1);
        for(int num:nums){
            presum+=num;
            if(map.containsKey(presum-k)){
                count+=map.get(presum-k);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        return count;
    }
}