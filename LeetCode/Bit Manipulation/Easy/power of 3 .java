https://leetcode.com/problems/power-of-three/
//problem no : 326

//Brute Force
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        while(n!=1)
        {
            if(n%3!=0)
                return false;
            n=n/3;
        }
        return true;
    }
}



/*
Explanation:
convert number into base 3 form 
as we know to power of 3 only 1 should be appera once in base 3 representation
so we should use match function or regex
We will use the regular expression above for checking if the string starts with 1 ^1, is followed by zero or more 0s 0* and contains nothing else ＄.
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}



/*
Explabnation:
here 1162261467 is maximum integer which is power of 3 i.e. 3^19
so if above number is divisible by n then n is also power of 3
3^(logbase3 to Integermax)=3^19.56=3^19
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}


