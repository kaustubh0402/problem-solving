https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
//problem no : 961

/*
Explanation : 
In given Question N+1 unique numbers out of 2N
i.e there is only one number which occurs N times others ALL one time only
HashSet Can be used but need solution by reducing Auxilary space
Suppose one elemnt ocuurs strictly more than N i.e. more than N+1
then problem can be solved using moore voting algorithm
but here one number occuring only N out of 2N
but one more condition is given that all others number are unique
Form above element we can conclude that
Throughout array there will be repeating number in last two element(as one number is repeated half time)

*/
class Solution {
    public int repeatedNTimes(int[] A) {
        int n=A.length;
        int count=1;
        int ans=A[0];
        for(int i=2;i<n;i++)
        {
            if(A[i]==A[i-1] || A[i]==A[i-2])
            {
                return A[i];
            }   
        }
        return ans;
    }
}