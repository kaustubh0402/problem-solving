https://leetcode.com/problems/generate-parentheses/
//Problem no : 22

class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(new StringBuilder(),0,0,n);
        return ans;
    }
    
    public void helper(StringBuilder curr,int open,int close,int n)
    {
        if(curr.length()==2*n)
        {
            ans.add(curr.toString());
            return;
        }
        if(open<n)
        {
            curr.append('(');
            helper(curr,open+1,close,n);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open)
        {
            curr.append(')');
            helper(curr,open,close+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}