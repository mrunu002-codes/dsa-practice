class Solution {
    public int longestConsecutive(int[] nums) {
        int longlen=0;
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int num:nums){
            map.put(num,Boolean.FALSE);
        }
        for(int num:nums){
            int currlen=1;
            int nextnum=num+1;
            while(map.containsKey(nextnum) && map.get(nextnum)==false){
                currlen++;
                map.put(nextnum,Boolean.TRUE);
                nextnum++;
            }
            int prevnum=num-1;
            while(map.containsKey(prevnum) && map.get(prevnum)==false){
                currlen++;
                map.put(prevnum,Boolean.TRUE);
                prevnum--;
            }
            longlen=Math.max(longlen,currlen);
        }
        return longlen;
    }
}
