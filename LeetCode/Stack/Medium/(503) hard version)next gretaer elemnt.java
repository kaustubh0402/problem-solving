https://leetcode.com/problems/next-greater-element-ii/
//Problem no : 503

/*
Explnation:
We need to follow similar approach like to find next greater element in array(Using stack)
In above approach we mark -1 for elements which are present in stack after one pass

But in given question Array is cicrcular so we need once again check for elemnts in stack
as there are elemnts in front of last elemnts of array
Only difference is we will  not push current elemnt as we have already find gretaer elemnt for current in first pass
We will check only for elemnts in stack after first pass

Example:
[1,3,5,2,1]
Now normal gretaer elemnt qyestion output will be:
[3,5,-1,-1,-1]
elements in stack will be [5,2,1]
 But as in given question array is circular
 i.e after last elemnt 1 we will start from first elemnt
 i.e 1,3,5,2,1 1,3,5,2,1 ....
 Now there are elemnts next to last elements 
 so answer after first pass same as normal greater elemnt
 [3,5,-1,-1,-1]
elements in stack will be [5,2,1]

Now check for [5,2,1] if gretaer number in array from left to right(as array is circular)
We will not push current elemnt as we have already found greter number for [1,3]
final answer
[3,5,-1,3,3]
 
*/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        if(n==0)
            return ans;
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                ans[st.pop()]=nums[i];
            st.push(i);
        }
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                ans[st.pop()]=nums[i];
        }
        return ans;
    }
}

https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int ans[]=new int[n];
        if(n==0)
          return ans;
        Stack<Integer> st=new Stack<>();
        ans[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && A[st.peek()]>=A[i])
              st.pop();
            ans[i]=(st.isEmpty())?-1:A[st.peek()];
            st.push(i);
        }
        return ans;
    }
}
