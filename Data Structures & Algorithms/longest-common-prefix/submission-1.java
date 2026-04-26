class Solution {
    public String longestCommonPrefix(String[] strs) {
        //sort it and compare first and last word thats it 
        //nikhil lohia
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        int n=strs.length-1;
        String first=strs[0];
        String last=strs[n];
        int i=0;
        int len=Math.min(first.length(),last.length());
        while(i<len && first.charAt(i)==last.charAt(i)){
             sb.append(first.charAt(i));
             i++;
             
        }
        return sb.toString();
    }
}