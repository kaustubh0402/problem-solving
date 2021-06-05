https://leetcode.com/problems/h-index/
//Problem no : 274

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        for(int i=0;i<n;i++)
        {
            if(citations[i]>=n-i)
                return n-i;
        }
        return 0;
    }
}


//Bucket sort 

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int freq[]=new int[n+1];
        for(int val:citations)
        {
            if(val>=n)
                freq[n]++;
            else
                freq[val]++;
        }
        int count=0;
        for(int i=n;i>=0;i--)
        {
            count+=freq[i];
            if(count>=i)
                return i;
        }
        return 0;
    }
}
