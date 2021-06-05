//https://leetcode.com/problems/count-and-say/
//problem no 38
/*
Explanation:
Use recursion as answer is dependent on previous answer
function pro is returning required answer for n-1 to produce answer for n
*/
//My solution
class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        return pro(countAndSay(n-1).toCharArray());
    }
    public String pro(char []s)
    {
        int n=s.length;
        StringBuffer ans=new StringBuffer();
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(s[i]!=s[i-1])
            {
                ans.append(count);
                ans.append(s[i-1]);
                count=1;
            }
            else
            {
                count++;
            }
        }
        ans.append(count);
        ans.append(s[n-1]);
        return ans.toString();
    }
}
