//https://leetcode.com/problems/plus-one/
//problem no :66

class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;  // we have to add 1 so intial carry is 1 which will add at end of array
        int ans[]=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int digitaddition=digits[i]+carry;  // addition of previous carry generated and current digit
            ans[i+1]=digitaddition % 10;       // mod 10 so that our addition of digit will not exceed 9
            carry=digitaddition / 10;             // carry forwarded to next digit which we will get by division
        }
        if(carry==1) // this is case where all digits are 9
        {
           ans[0]=1;
           return ans;   
        }
        return Arrays.copyOfRange(ans,1,n+1);   // else we will not return first digit
    }
}