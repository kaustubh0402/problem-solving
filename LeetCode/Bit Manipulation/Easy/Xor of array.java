https://leetcode.com/problems/xor-operation-in-an-array
//Problem no 1486

//Brute Force
class Solution {
    public int xorOperation(int n, int start) {
        int answer=0;
        for(int  i=0;i<n;i++)
        {
            answer=answer^(start+2*i);
        }
        return answer;
    }
}