https://leetcode.com/problems/longest-mountain-in-array/
problem no : 845

class Solution {
    public int longestMountain(int[] A) {
        int begin=0;
        int end=A.length-1;
        int count=0;
        while(begin<=end)
        {
            int cntup=0,cntdown=0;
            int start=begin;
            while(start<end && A[start]<A[start+1])
            {
                start++;
                cntup++;
            }
            while(start<end && A[start]>A[start+1])
            {
                start++;
                cntdown++;
            }
            if(cntup==0 && cntdown==0)
                start++;
            begin=start;
            if(cntup==0 || cntdown==0)
                continue;
            count=Math.max(count,cntup+cntdown+1);
        }
        return count;
    }
}