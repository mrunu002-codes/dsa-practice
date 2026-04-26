class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character,Integer> map=new HashMap<>();
        // Step 1: Store frequency of characters in t
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0;
        int start=0;
        int minwinlen=Integer.MAX_VALUE;;
        int required=t.length(); // how many chars still needed

        // Step 2: Expand window using right pointer
        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);
            //if this char is needed
            if(map.containsKey(ch) && map.get(ch)>0){
                required--;
            }
            // Reduce its count (even if not needed)
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // Step 3: When valid window found, try shrinking
            while(required==0){
                int currlen=right-left+1;
                if(currlen<minwinlen){
                     minwinlen=currlen;
                     start=left;
                }
                char leftchar=s.charAt(left);
                // Put back the left char
                map.put(leftchar,map.getOrDefault(leftchar,0)+1);

                if(map.containsKey(leftchar) && map.get(leftchar)>0){
                    required++;
                }
                left++;
                
            }
        }
        return minwinlen==Integer.MAX_VALUE? "" : s.substring(start,start+minwinlen);
    }
}
