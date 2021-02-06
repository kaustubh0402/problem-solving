https://leetcode.com/problems/simplify-path/
//Problem no : 71

/*
Explanation:
Duue to ../ in string we have to use stack to remove last added directory
*/


class Solution {
    public String simplifyPath(String path) {
        int n=path.length();
        int i=1;
        String curr="";
        Stack<String> st=new Stack<>();
        while(i<n)
        {
            curr="";
            while(i<n && path.charAt(i)!='/')
            {
                curr+=(path.charAt(i));
                i++;
            }
            if(curr.equals("..") && !st.isEmpty())
                st.pop();
            else if(curr.length()!=0 && !curr.equals(".") && !curr.equals(".."))
                st.push(curr);
            i++;
        }
        String ans="";
        while(!st.isEmpty())
        {
            ans='/'+st.pop()+ans;
        }
        return ans==""?"/":ans;
    }
}