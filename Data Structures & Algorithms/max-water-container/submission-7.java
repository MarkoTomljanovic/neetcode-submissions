class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int area = 0;

        while (i < j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            int curentArea = width * height;
            area = Math.max(area, curentArea);

            if (heights[i] >= heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }
}
