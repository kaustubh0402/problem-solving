https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
//Problem no : 1209

/*
Explanation:
Brute force:
We will iterate over string till we will not found k consecutive char
It will give TLE

Optimization:
we will use stack
Stack of pair of character and count
We will check that if stcack top and current char is same or not
if same then we update count of stack top count by 1
else we have to push new stack top count as 1

And for every char we will check if stack top count equal to k 
if yes then we have to remove it from stack

final answer is reverse of stack

*/

class Solution {
    class Node
    {
        char c;
        int v;
        Node(char curr,int val)
        {
            c=curr;
            v=val;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Node> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(!st.isEmpty() && st.peek().c==curr)
                st.peek().v++;
            else
                st.push(new Node(curr,1));
            if(st.peek().v==k)
                st.pop();
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
        {
            char curr=st.peek().c;
            int freq=st.pop().v;
            for(int i=0;i<freq;i++)
                ans.append(curr);
        }
        return ans.reverse().toString();
    }
}