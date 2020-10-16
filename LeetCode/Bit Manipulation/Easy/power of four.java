https://leetcode.com/problems/power-of-four/
//Problem no : 342

class Solution {
    public boolean isPowerOfFour(int n) {
        int check=Integer.parseInt("1010101010101010101010101010101",2);
        return ((n>0) && (n&(n-1))==0 && (n|(check))==check);
    }
}



public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && (Integer.toBinaryString(num).length()-1)%2==0;
    }
