class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        for(int i = 0;i<heights.length;i++){            
            for(int j=0;j<heights.length;j++){
                result = Math.max(result,(j-i)
                *Math.min(heights[i],heights[j]));
            }
        }
        return result;
    }
}
