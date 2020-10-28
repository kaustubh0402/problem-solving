https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
//problem no : 1356

/*
Explanation:
1. Create Look up table for given length.
2. Now we know that we have maximum 32 bits in integer
   so number of 1 in given number will be in 0 to 32
3. Iterate over number for 0 to 32 let say i
    1) Check if given no of bits equal to i
        then sort numbers according to number who have equal no. of bits(equal to i)
*/


class Solution {
    public int[] sortByBits(int[] arr) {
        int len=arr.length;
        int ans[]=new int[len];
        int bit[]=new int[10001];
        for(int i=1;i<10001;i++)
        {
            bit[i]=bit[i>>1]+(i&1);
        }
        int index=0;
        for(int i=0;i<=32;i++)
        {
            int start=index;
            for(int j=0;j<len;j++)
            {
                if(bit[arr[j]]==i)
                {
                    ans[index]=arr[j];
                    index++;
                }
            }
            Arrays.sort(ans,start,index);
        }
        return ans;
    }
}
