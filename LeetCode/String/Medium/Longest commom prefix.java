//https://leetcode.com/problems/longest-common-prefix/
//problem no : 14
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
          return "";   
        StringBuffer s=new StringBuffer();
        int min=Integer.MAX_VALUE;
        String temp="";
        for(int i=0;i<strs.length;i++)
        {
            if(min>strs[i].length())
            {
                min=strs[i].length();
                temp=strs[i];
            }
        }
        for(int i=0;i<min;i++)
        {
            int j;
            for(j=0;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=temp.charAt(i))
                {
                    break;
                }
            }
            if(j==strs.length)
                s.append(temp.charAt(i));
            else
                break;
        }
        return s.toString();
    }
}