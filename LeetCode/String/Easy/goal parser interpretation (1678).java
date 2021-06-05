https://leetcode.com/problems/goal-parser-interpretation/
//problem no : 1678

class Solution {
    public String interpret(String command) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<command.length();i++)
        {
            int curr=command.charAt(i);
            if(curr=='G')
                ans.append('G');
            else if(curr=='(')
            {
                if(command.charAt(i+1)==')')
                {
                    ans.append('o');
                    i++;
                }
                else
                {
                    ans.append("al");
                    i+=3;
                }
            }
        }
        return ans.toString();
    }
}