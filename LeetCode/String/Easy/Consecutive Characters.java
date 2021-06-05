https://leetcode.com/problems/consecutive-characters/
//Problem no : 1446

class Solution {
    public int maxPower(String s) {
        int count=1,max=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                max=Math.max(max,count);
                count=1;
            }
        }
        max=Math.max(max,count);
        return max;
    }
}