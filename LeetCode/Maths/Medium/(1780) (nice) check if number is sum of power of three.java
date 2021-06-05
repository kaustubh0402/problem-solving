https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
//Problem no : 1780

/*
Brute force:
Here as we know maximum power of 3 in integer value can be 19
So we will check each and every possibilty of of that 19 powers combination
*/

class Solution {
    boolean ans=false;
    public boolean checkPowersOfThree(int n) {
        helper(n,-1);
        return ans;
    }
    
    public void helper(int n,int start)
    {
        if(n<0)
            return ;
        if(n==0)
        {
            ans=true;
            return ;
        }
        for(int i=start+1;i<19;i++)
           helper(n-(int)Math.pow(3,i),i);
    }
}

/*
Explanation: 
sum Distinct power of 3
I.e 3^0 , 3^1 ,3^2 ,3^3 ...

Now consider sum of any power of 3 except 3^0
Sum will be divisible by 3 (as every term in sum is divisible by 3)

Now we will consider 3^0 also if it is present then 
sum will have remainder 1 after division by 3

In any case we will not get remainder 2 so we will return false if we get rem==2
so basically our task is to check if rem==1 then we will decremnt n-1
and if rem==0 then we will change n=n/3 till n!=0
if rem==2 then return false

in other words if sum is divisible by 3 then we are taking 3 common and divide by 3 
if rem is 1 then we are considering 1 as 3^0 and removing it
*/


//Math Trick
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n!=0)
        {
            if(n%3==2)
                return false;
            n=n%3==1?n-1:n/3;
        }
        return true;
    }
}


//recursive code:
class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n==1)
            return true;
        if(n%3==0)
            return checkPowersOfThree(n/3);
        if(n%3==1)
            return checkPowersOfThree((n-1)/3);
        return false;
    }
}


