class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //code with mik
        int n=people.length;
        int boats=0;
        int l=0;
        int r=n-1;
        Arrays.sort(people);
        while(l<=r){
            if(people[l]+people[r]<=limit){
                l++;
                r--;
                boats++;
            }
            //send the heavy boat alone (which is at end)
            //so right --
            else{
                r--;
                boats++;
            }
        }
        return boats;
    }
}