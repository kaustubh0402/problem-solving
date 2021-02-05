https://leetcode.com/problems/subarray-product-less-than-k/
//Problem no : 713

/*
Explanation:
Sliding window approac:
consider our window from start to end (see program)
Start and end are varibles and 
product is variable which is product of all numbers is window from start to end

case 1:
  Suppose our product of entire window value is greater than given value(K)
  Then we should increase start and exlcude value at start from product
  Doing above will reduce product i.e product/arr[start]
  and start++ (window size decrease)
  
Case 2:
  Suppose product of window is less than k
  So we should increment end and include value at end in product array
  Doing above will increase product i.e product*arr[end]
  and end++
  Now we have to increment answer...follow below steps:
     1) As for every iteration one new value is added
	 2) so we have to think about subarray whose containing new value(i.e. value at end)
     3) total new subarray for variable at end will be end-start
     4) add above value to ans

Note: Consider corner cases: I have check end<n ,start<n so that array should not out of bound	 
*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length==0)
            return 0;
        int product=nums[0];
        int n=nums.length;
        int start=0,end=0;
        int ans=0;
        while(end<n && start<n)
        {
            if(product<k)
            {
                end++;
                if(end>=start)
                {
                    ans+=(end-start);
                }
                if(end<n)
                {
                    product*=nums[end];
                }
            }
            else
            {
                product/=nums[start];
                start++;
            }
        }
        return ans;
    }
}


//Simplified
/*
Leetcode explanation:

Intuition
For each right, call opt(right) the smallest left so that t
he product of the subarray nums[left] * nums[left + 1] * ... * nums[right] is less than k. 
opt is a monotone increasing function, so we can use a sliding window.

Algorithm
Our loop invariant is that left is the smallest value so that the product in the window 
prod = nums[left] * nums[left + 1] * ... * nums[right] is less than k.
For every right, we update left and prod to maintain this invariant. 
Then, the number of intervals with subarray product less than k and with right-most coordinate right, 
is right - left + 1. We'll count all of these for each value of right.

*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}