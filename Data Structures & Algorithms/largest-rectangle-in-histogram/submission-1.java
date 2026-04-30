class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        int maxArea=0;

        nse=findNSE(heights,n);
        pse=findPSE(heights,n);
        for(int i=0;i<n;i++){
            int width=nse[i]-pse[i]-1;
            int area=heights[i]* width;
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    private int[] findNSE(int[] heights,int n){
        int[] nse=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;

    }
    private int[] findPSE(int[] heights,int n){
        int[] pse=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            pse[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
