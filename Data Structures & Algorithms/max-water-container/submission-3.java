class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int result = 0;

        while(l<r){
            int a = r-l;
            int b = Math.min(heights[l],heights[r]);
            int newResult = a*b;
            result = Math.max(result,newResult);
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }
        return result;
    }
}
