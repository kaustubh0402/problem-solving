https://www.geeksforgeeks.org/number-of-pairs-in-an-array-with-the-sum-greater-than-0/

/*
Given an array arr[] of size N, the task is to find the number of distinct pairs in the array whose sum is > 0.

Examples: 

Input: arr[] = { 3, -2, 1 } 
Output: 2 
Explanation: 
There are two pairs of elements in the array whose sum is positive. They are: 
{3, -2} = 1 
{3, 1} = 4

Input: arr[] = { -1, -1, -1, 0 } 
Output: 0 
Explanation: 
There are no pairs of elements in the array whose sum is positive. 
*/ 


class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	    Arrays.sort(a);
	    int start=0;
	    int end=n-1;
	    long ans=0;
	    while(start<end)
	    {
	        if(a[start]+a[end]>0)
	        {
	           ans+=((long)(end-start));
	           end--;
	        }
	        else
	        {
	            start++;
	        }
	    }
	    return ans;
	}
} 