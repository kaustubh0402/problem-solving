https://leetcode.com/problems/single-number/
//problem no :136

/*
Brute force will be two loops , iterating for each element

Another solution is using hashmap or hashset but using extra space

Basically we need to know following two properties of XOR
1.  value ^ value=0
2.  value ^ 0 =value
3.  XOR follow Associative law (a1^a2^a3^a4)=(a2^a1^a4^a1)
Using above properties we can eliminate all elemnts occuring twice
Remaining will be answer
*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            ans^=nums[i];
        }
        return ans;
    }
}
