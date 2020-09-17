//https://leetcode.com/problems/to-lower-case/
//problem no.709
class Solution {
    public String toLowerCase(String str) {
        char[] lc=str.toCharArray();
        for(int i=0;i<str.length();i++)
        {
            if(lc[i]<=91 && lc[i]>=65)
            lc[i]=(char)(lc[i]+32);
        }
        return String.valueOf(lc);
    }
}