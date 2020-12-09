https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//problem no : 1010

/*
1) brute Force: O(n^2)
   Iterarte over each elements of array
     check whether sum of current and all next elements are divisnle by 60 or not
2) using HashMap
    Statndard HashMap method
	
===***Optimal***===
Hint:
1.We only need to consider each song length modulo 60.
2.We can count the number of songs with (length % 60) equal to r, and store that in an array of size 60.
Here actually we have to solve 2 sub problems
  1. Modulo sum...we can divide each number in array by 60
  2. and we have to find number of elements who have remainder equal to 60-remainder of current

Corner case : [60,60,60] as 60%60==0 and 
if we perform 60-(60%60) form above formulae 60-remainder of current then we will end up in rem[60]
which will error of Array out of bound
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int rem[]=new int[60];
        int count=0;
        for(int i=0;i<time.length;i++)
        {
            if(time[i]%60==0) //To avoid array out of bound ..explnation in corner case 
                count+=rem[0];
            else
                count+=rem[60-time[i]%60];
            
			rem[time[i]%60]++; //remember to update the remainders for each iteration
        }
        return count;
    }
}