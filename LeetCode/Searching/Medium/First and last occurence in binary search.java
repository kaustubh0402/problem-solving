https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//problem no : 34

/*
We will use Binary search for optimal
first we will find first occurence and then second occurence'
we can also use this tecnique for calculating number of times given occuring number in sorted array
Explanation of modified binary search in comments
*/

/*
Brute force O(n)
Traverse through array till we find first occurence mark thaty number
again cintinue till we find greater than target in array and mark that second occurence
*/

//optimal O(logn)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int low=0,high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
			//for first occurence previous element of of mid pointer should be strictly less than target
			//i.e. nums[mid-1]<target
			//corner case will be mid==0 as mid-1 will throw array out of index error
            if((mid==0 || nums[mid-1]<target) && (nums[mid]==target))
            {
                ans[0]=mid;
                break;
            }
			//This line is also important we are not considering less than equal to
			//Reason: suppose elemnt at mid is target but previous (mid-1) element also target(i.e. nums[mid-1]=target)
			//so above loop will fail and come to next now for above case equal to should no there
			//if it is there tthen it will consider array from mid+1 to....n but our answer will be in 0 to mid-1..
			//if not understood check below comments:
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        
        low=0;
        high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
			//for last occurence next element of mid pointer should be strictly greater than target
			//i.e. nums[mid+1]>target
			//corner case will be mid==n-1 as mid+1 will throw array out of index error
            if((mid==nums.length-1 || nums[mid+1]>target) && (nums[mid]==target))
            {
                ans[1]=mid;
                break;
            }
			//Now here we have to consider equal to also as 
			//if we found target at mid but not last occuremce then our answer should be in mid+1....n-1
			//above condition will be ensure if there is equal to sign
			//conider case [2,2] target=2 fails if we not use equal to condition
            else if(nums[mid]<=target)
                low=mid+1;
            else
                high=mid-1;
        }
        return ans;
    }
}