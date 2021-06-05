//https://leetcode.com/problems/longest-common-prefix/
//problem no : 14
/*
Explanation:
1) find minimum length word(temp) from given list
2) compare each letter of temp word with respective letters of all other words in list
   append letter in ans if letter of temp(small length word) found in each word from list
*/	
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