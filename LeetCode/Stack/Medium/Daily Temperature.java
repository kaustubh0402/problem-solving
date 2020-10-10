//https://leetcode.com/problems/daily-temperatures/
//Problem no 739

//Solution 2
/*
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st=new Stack<Integer>();
        Stack<Integer> index=new Stack<Integer>();
        int len=T.length;
        int ans[]=new int[len];
        st.push(T[0]);
        index.push(0);
        for(int i=1;i<len;i++)
        {
            while(!st.isEmpty() && T[i]>st.peek())
            {
                st.pop();
                int ind=index.pop();
                ans[ind]=i-ind;
            }
            st.push(T[i]);
            index.push(i);
        }
        return ans;
    }
}
*/