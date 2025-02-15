// 84. Largest Rectangle in Histogram
// Solved
// Hard
// Topics
// Companies
// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

// Example 1:


// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:


// Input: heights = [2,4]
// Output: 4
 

// Constraints:

// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE; 
        Stack<int[]> stack = new Stack<>(); 

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] popped = stack.pop();
                int height = popped[1];
                int width = stack.isEmpty() ? i : i - stack.peek()[0] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(new int[]{i, h});
        }
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            int height = popped[1];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek()[0] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
