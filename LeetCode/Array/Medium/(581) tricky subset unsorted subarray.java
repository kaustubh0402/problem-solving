https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//Problem no : 581

/*
Explanation:
As we required continuos unorted array
We have to validate following condition:
While moving from left to right:
1.  if we find that current number is greater than max elemnt found till curr number then our property is true till curr element.
2.   else curr index should be in unsorted array
Last element we found violating property will be last element of unsorted array

Similarly from right to left
1.  if we find that current number is smaller than min elemnt found till curr number then our property is true till curr element.
2.   else curr index should be in unsorted array
Last element we found violating property will be first element of unsorted array

------> should be incresing (current element should be gretaer than max element found in subarray [0,curr index])
2,6,4,8,10,9,15
<------should be decreasing(current element should be smaller than min element found in subarray [curr index,r])
*/


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int r=nums.length-1;
        int l=0;
        int start=0;
        int end=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        while(r>=0)
        {
            if(nums[l]>=max)
                max=nums[l];
            else
                end=l;
            if(nums[r]<=min)
                min=nums[r];
            else
                start=r;
            r--;
            l++;
        }
        return end-start+1;
    }
}


/*
Simple to understand not clean code
The idea behind this method is that the correct position of the minimum element in the unsorted subarray
 helps to determine the required left boundary. 
 Similarly, the correct position of the maximum element in the unsorted subarray helps 
 to determine the required right boundary.
*/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                min = Math.min(min, nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                  max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}