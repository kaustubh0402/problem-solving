https://leetcode.com/problems/house-robber/
//problem no : 198

/*
Explanation
Recurrence relation :
 t(n)= Max between t(n-1) and t(n-2)+ currnet(n)
 
Now as per given condition we cnanot loot from adjacent house
dp[i] will store maximum looted till ith house
Now we have to make choice either we take i-1 and leave i (as no adjacent should taken)
or take i-2 and current num[i]
which will give maximum will take 

*/

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}


//Recursive dp (memorization) Top down
class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
    
    int helper(int nums[],int i,int dp[])
    {
        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(helper(nums,i-1,dp),helper(nums,i-2,dp)+nums[i]);
    }
}

//Using O(1) space
//Above problem is same as fibonaaci as we have concern about i-1 and i-2 value we can maintain 2 variables
public int rob(int[] nums) { 
    if (nums.length == 0)
		return 0;
    int prev1 = 0;
	int prev2 = 0;
	for (int num: nums)
	{
		int tmp= prev1;
		prev1 = Math.max(prev2 + num, prev1);
		prev2 = tmp;
	}
	return prev1;
}