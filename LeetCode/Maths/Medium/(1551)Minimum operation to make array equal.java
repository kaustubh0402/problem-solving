https://leetcode.com/problems/minimum-operations-to-make-array-equal/
//problem no : 1551

class Solution {
    public int minOperations(int n) {
        int ans=0;
        for(int i=0;i<n/2;i++)
            ans+=(n-(2*i+1));
        return ans;
    }
}
//short in O(1) using Ap formula
class Solution {
    public int minOperations(int n) {
        return (n/2)*(n+1)-((n/2)*(2+2*(n/2))/2);
    }
}