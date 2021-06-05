https://leetcode.com/problems/largest-rectangle-in-histogram/
//Problem no : 84

/*
Explanation:
1) Brute force will be O(n^2)
It is hard version of nearest smallest elemnt in left side of number in array
1. Basic idea is we will consider every bar in array
2. While traversing array we will conisder current bar as max height for rectangle
3. Now we have to found just smaller elemnt than above current elemnt from left and right of array 
4. Now our height become : curr elemnt
5. and width become : right-left+1
6. To find left and right element which is just smaller than current in O(1) we need to precompute above in left[] and right array
7. left[i] : considering ith elemnt as max height in rectangle left[i] denotes just smaller elemnt than currnet max height position in array
8. right[i] : same as left[i] but denotes from right part of array
9. We will use stack for precomputation 
    //Watch solution of 503 from github nearest smaller elemnt
10. Take care of corner cases
*/


class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        int n=heights.length;
        Stack<Integer> s=new Stack<Integer>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop();
            left[i]=s.isEmpty()?0:s.peek()+1;
            s.push(i);
        }
        s=new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop();
            right[i]=s.isEmpty()?n-1:s.peek()-1;
            s.push(i);
        }
        for(int i=0;i<n;i++)
            ans=Math.max(ans,(right[i]-left[i]+1)*heights[i]);
        return ans;
    }
}
