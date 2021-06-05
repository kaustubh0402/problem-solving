https://leetcode.com/problems/find-lucky-integer-in-an-array/

//Solution:
https://leetcode.com/problems/find-lucky-integer-in-an-array/discuss/557113/3-Approaches-(%2B2-Variations)


class Solution {
    public int findLucky(int[] arr) {
        int freq[]=new int[501];
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        int ans=-1;
        for(int i=1;i<=500;i++)
        {
            if(freq[i]==i)
                ans=i;
        }
        return ans;
    }
}
