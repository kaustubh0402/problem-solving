https://leetcode.com/problems/number-complement/
//Problem no :476 and 1009


//brute force
/*
Explanation:
Here calculating all 1 till num 
suppose num=5 (101)  then calculate number as (111)
Then Subtracting 111-101=010 as answer;
*/
class Solution {
    public int findComplement(int num) {
        int number=0;
        while(num>number)
        {
            number=(number<<1) | 1;
			//Alternative: number+=Math.pow(2,i);
        }
        return number-num;
    }
}



//optimal
/*
here (-num-1)=~num
Generally if we have to calculate complement we follow above method
Here logic is same as brute force
Instead of while loop for calculating numbers with all one
we are using Highest set bit of given number then right hift that bit
After -1 from above result we get number which have all 1 
*/
class Solution {
    public int findComplement(int num) {
        if(num==0) //Explicitely handel case for 0
            return 1;
        return (-num-1) & ((Integer.highestOneBit(num)<<1)-1);
    }
}
