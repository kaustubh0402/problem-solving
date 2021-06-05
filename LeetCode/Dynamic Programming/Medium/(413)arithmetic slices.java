https://leetcode.com/problems/arithmetic-slices/
//Problem no : 413

/*
Explanation:
We will find maximum continuos Arithmtic subarray
Every Ap less than above length off subarray will also be Ap
Example: 1 2 3 4 8 9
subarray 1 2 3 4 is Ap.. Hence [1,2] [2,3] [3,4] [1,2,3] [2,3,4] are also Ap
Suppose we found maximum continuos array till Ap exist as k
then total subarray of k length=k*(k+1)/2 but need to exclude length of 1 and 2 subarray (Mentioned in question)
i.e. k*(k+1)/2-(k+k-1)

*/
//Not clean code
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int ans=0;
        int k=0;
        int n=A.length;
        if(n<3)
            return 0;
        int diff=A[1]-A[0];
        for(int i=1;i<n;i++)
        {
            if(diff==A[i]-A[i-1])
                k++;
            else
            {
                if(k>=2)
                    ans+=((k+1)*(k+2)/2)-(k+k+1);
                k=1;
                diff=A[i]-A[i-1];
            }
        }
        if(k>=2)
            ans+=((k+1)*(k+2)/2)-(k+k+1);
        return ans;
    }
}

//Clean code
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }
}