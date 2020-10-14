https://leetcode.com/problems/total-hamming-distance/
//problem no : 477
//Brute Force (Look up table) //refer counting bit problem
class Solution {
    public int totalHammingDistance(int[] nums) {
        int bit_array[]=new int[256];
        for(int index=1;index<256;index++)
        {
            bit_array[index]=bit_array[index>>1] + (index & 1);
        }
        int len=nums.length;
        int answer=0;
        for(int index_outer=0;index_outer<len;index_outer++)
        {
            for(int index_inner=index_outer+1;index_inner<len;index_inner++)
            {
                int xor_value=nums[index_outer]^nums[index_inner];
                answer=answer+bit_array[xor_value & 0xFF];
                // xor_value=xor_value>>8;
                answer=answer+bit_array[xor_value>>8 & 0xFF];
                // xor_value=xor_value>>8;
                answer=answer+bit_array[xor_value>>16 & 0xFF];
                // xor_value=xor_value>>8;
                answer=answer+bit_array[xor_value>>24 & 0xFF];
            }
        }
        return answer;
    }
}


/*
Explanation :
Instead of checking every pair we will consider all number bitwise
Maximum bits in every integer is 32 so
we will check set bit in every position in every integer
basically we are calculating haming distance bitwise for all numbers not numberwise
suppose 20 numbers are there, so we will consider all 32 bits in 20 numbers individually
count set bits (1) for all number in LSB first 
then haming distance for that particular bit for all numbers will (set bit)*(unset bit)
i.e. (set bit)(n-set bit)
we will add above to answer
repeat this process for all 32 bits
*/


//optimal
class Solution {
    public int totalHammingDistance(int[] nums) {
        int answer=0;
        int len=nums.length;
        for(int index=0;index<32;index++)
        {
            int bit_count=0;
            for(int num_index=0;num_index<len;num_index++)
            {
                bit_count=bit_count+((nums[num_index]>>index) & 1);
            }
            answer=answer+(bit_count*(len-bit_count));
        }
        return answer;
    }
}
