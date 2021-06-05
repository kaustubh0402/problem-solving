/*
Given an integer array of size  N . 
You have to find sum of bit differences in all pairs that can be formed from array elements. 
Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
For example, bit difference for 2 and 7 is 2. 
Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).

Input: N = 2, arr[] = {1, 2}
Output: 4
Explanation: All possible pairs are [(1,1) (1,2) 
(2,1) (2,2)] their respective Bit differences 
are 0 ,  2 , 2 , 0
*/

//Refer total Haming distance problem in bit manipulation in leetcode
class Solution
{
    public static long sumBitDiff(int arr[], int n) 
    { 
        long ans=0;
        for(int i=0;i<32;i++)
        {
            int cnt=0;
            for(int j=0;j<n;j++)
            {
               if(((arr[j]>>i)&1)==1)
                 cnt++;
            }
            ans+=2*((long)cnt*(n-cnt));
        }
        return ans;
    } 
  
}
