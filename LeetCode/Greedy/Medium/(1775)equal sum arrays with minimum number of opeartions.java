https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
//Problem no : 1775

/*
Short Explanation:
We will calculate sum of 2 array elemenst if two sum are equal then return 0 let say sum1 and sum2
Else we have to think about absolute difference between two sum(sum2-sum1)

Now we can increase sum of array whose sum less than second array or decrease sum of array whose sum is greater than other array
We have to do above process in minimum operation

Suppose we have to increase then we can increase 1 to 2,3,4,5,6
As we have to compensate our difference in min operation it is always preferable to increase 1 to 6
and if we want to decrease in other array to 6 to 1 (diff=5)
Here we came to know that we should use greedy method

Implementation:
* find sum of both arrays
* General Idea is we will increase elemnt from array whose sum is smalller and decrease elemnt from array whose sum is greater
* then we will find frequency of element in array whose sum is greater and store in frequency array
* While storing I have store current elemnt-1 (as max difference will be always curr-1 (if not clear see example in explanation)
* Similarly we will find frequency of element whose sum is smaller
* While storing above we will use (6-curr) (consider example conversion of 1 to 6 here diff is (6-1)==s) 

*/

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n1;i++)
            sum1+=nums1[i];
        for(int i=0;i<n2;i++)
            sum2+=nums2[i];
        if(sum1==sum2)
            return 0;
        int small=n1<n2?n1:n2;
        int big=n1<n2?n2:n1;
        if(small*6<big*1)
            return -1;
        int great[]=new int[6];
        if(sum1<sum2)
        {
            for(int i=0;i<n1;i++)
                great[5-nums1[i]+1]++;
            for(int i=0;i<n2;i++)
                great[nums2[i]-1]++;
        }
        else
        {
            for(int i=0;i<n1;i++)
                great[nums1[i]-1]++;
            for(int i=0;i<n2;i++)
                great[5-nums2[i]+1]++;
        }
        int req=Math.abs(sum2-sum1);
        int op=0;
        for(int i=5;i>=1 && req>0;i--)
        {
            for(int j=0;j<great[i] && req>0;j++)
            {
                op++;
                req=req-i;
            }
        }
        return op;
    }
}