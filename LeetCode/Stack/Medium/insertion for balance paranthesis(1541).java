https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
//Problem no : 1541

class Solution {
    public int minInsertions(String s) {
        Stack<Character> ans=new Stack<Character>();
        int count=0;
        int req=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(count==1)
                {
                    if(!ans.empty())
                    {
                        req++;
                    }
                    else
                    {
                        req+=2;
                        ans.push('(');
                    }
                    count=0;
                }
                else
                    ans.push('(');
            }
            else
            {
                if(!ans.empty())
                {
                    if(count==1)
                    {
                        count=0;
                        ans.pop();
                    }
                    else
                    {
                        count++;
                    }
                }
                else
                {
                    if(count==1)
                    {
                        req++;
                        count=0;
                    }
                    else
                    {
                        count++;
                    }
                }
            }
        }
        if(count==1)
        {
            req++;
            if(!ans.empty())
                ans.pop();
            else
                req++;
        }
        req+=ans.size()*2;
        return req;
    }
}