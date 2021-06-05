https://leetcode.com/problems/xor-operation-in-an-array
//Problem no 1486

//optimal 
class Solution {
    public int xorOperation(int n, int start) {
        /**
            First of all, we need to know (2^4^6^8^10) == 2^(4^6^8^10) == 2^((4^6)^(8^10)) = 2^(2^2) = 2
        
            (1) start >> 1, to match add 2*n as add n;
            (2) then &1 to check if start >> 1 is odd or even, so we will know last digit start with 0 or 1.
            (3) then &1 to figure out n is odd or even
            (4) start >> 1 is odd, then n is odd, result is (^pairs of 1)^ first one
                                   then n is even, result is (^pairs of 1)^ last one ^ first one
            (5) start >> 1 is even, then n is even, the result is (^pairs of 1)
                                    then n is odd, the result is (^pairs of 1)^last one.
            (6) the final result: (result from step 4, 5) * 2 + ss;  ss is the last digit XOR result.
        **/ 
            int ss = 0;
            if( start % 2 == 1 && n % 2 == 1){
                ss = 1;
            }
            start = start>>1;
            if( (start & 1) == 1){
                if( (n & 1) == 1){
                    return (((n-1)/2 & 1) ^ start) * 2 + ss;
                }
                else{
                    return (((n-2)/2 & 1) ^ start ^ (start + n-1)) * 2 + ss;
                }
            }
            else{
                if( (n & 1) == 1){
                    return (((n-1)/2 & 1) ^ (start + n - 1)) * 2 + ss;
                }
                else{
                    return (n/2 & 1) * 2 + ss;
                }
            }     
    }
}


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