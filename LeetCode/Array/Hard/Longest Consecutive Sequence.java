//https://leetcode.com/problems/longest-consecutive-sequence/
//problem no 128
/*
Explanation:
This optimized algorithm contains only two changes from the brute force approach: the numbers are stored in a HashSet (or Set, in Python) to allow O(1)O(1) lookups, and we only attempt to build sequences from numbers that are not already part of a longer sequence. This is accomplished by first ensuring that the number that would immediately precede the current number in a sequence is not present, as that number would necessarily be part of a longer sequence.

1) Add all elements to hashset
2) now we will find minimum element of each consecutive sequence
    for that we will check whether current_number-1 is present in set or not
		if present then current element will not be minimal element of that sequence so continu
		if not present then current element is minimal 
		if we found minimal element the we have to check consecutive sequence from cuurent
		so we will loop till element in squence present in hashset
		
Time complexity : O(n (hashset) +n (iterarting array) + n (consecutive sequence) )
Time Complexity : O(3 n)

*/
//My Solution
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> allvalues=new HashSet<Integer>();
        for(int val:nums)
            allvalues.add(val);
        
        int longest_seq=0;
        
        for(int index=0;index<nums.length;index++)
        {
            int current_seq=0;
            if(!allvalues.contains(nums[index]-1))
            {
                int current_element=nums[index];
                while(allvalues.contains(current_element))
                {
                    current_seq++;
                    current_element++;
                }
            }
            longest_seq=Math.max(longest_seq,current_seq);
        }
        return longest_seq;
    }
}
