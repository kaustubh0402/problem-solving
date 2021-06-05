//https://leetcode.com/problems/jewels-and-stones/
//problem 771
class Solution {
    public int numJewelsInStones(String J, String S) {
        final int temp=65;
        int freq[]=new int[60];
        char ja[]=J.toCharArray();
        char sa[]=S.toCharArray();
        int cnt=0;
        for(int i=0;i<ja.length;i++)
        {
            freq[ja[i]-temp]++;
        }
        for(int i=0;i<sa.length;i++)
        {
            if(freq[sa[i]-temp]>0)
                cnt++;
        }
        return cnt;
    }
}