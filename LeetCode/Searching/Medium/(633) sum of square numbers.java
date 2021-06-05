https://leetcode.com/problems/sum-of-square-numbers/
//problem no : 633

/*
Explanation:
Read solution from same question
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Long> h=new HashSet<>();
        for(long i=0;i<=(int)Math.sqrt(c);i++)
            h.add(i*i);
        for(long i=0;i<=(int)Math.sqrt(c);i++)
            if(h.contains(c-i*i))
                return true;
        return false;
    }
}


class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==1)
            return true;
        for(long i=0;i*i<=c;i++)
        {
            long check=c-(int)i*i;
            if(search(i,(long)c,check))
                return true;
        }
        return false;
        
    }
    
    boolean search(long start,long end,long c)
    {
        while(start<=end)
        {
            long mid=start+(end-start)/2;
            if(mid*mid==c)
                return true;
            if(mid*mid<c)
                start=mid+1;
            else
                end=mid-1;
        }
        return false;
    }
}