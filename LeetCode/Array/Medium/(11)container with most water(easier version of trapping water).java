https://leetcode.com/problems/container-with-most-water/
//problem no : 11


//see solution and explanation of trapping water
class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int ans=Integer.MIN_VALUE;
        while(start<end)
        {
            int width=end-start;
            int vertical=Math.min(height[start],height[end]);
            ans=Math.max(ans,width*vertical);
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return ans;
    }
}