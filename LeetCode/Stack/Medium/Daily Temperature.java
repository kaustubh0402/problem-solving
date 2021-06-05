//https://leetcode.com/problems/daily-temperatures/
//Problem no 739

//Solution 1(Inbuild Stack)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st=new Stack<Integer>();
        int len=T.length;
        int ans[]=new int[len];
        st.push(0);
        for(int i=1;i<len;i++)
        {
            while(!st.isEmpty() && T[i]>T[st.peek()])
            {
                int index=st.pop();
                ans[index]=i-index;
            }
            st.push(i);
        }
        return ans;
    }
}
//Solution 2 (Stack implementation)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int st[]=new int[len];
        int ans[]=new int[len];
        int top=-1;
        st[++top]=0;
        for(int i=1;i<len;i++)
        {
            while(top!=-1 && T[i]>T[st[top]])
            {
                int index=st[top--];
                ans[index]=i-index;
            }
            st[++top]=i;
        }
        return ans;
    }
}
//Solution 3 (Unnecessary use of extra space)
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