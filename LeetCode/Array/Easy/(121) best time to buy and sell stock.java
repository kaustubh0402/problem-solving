https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Problem no : 121

/*
Explanation:
We observe that we can make maximum profit if diff between selling and buying 
Our aim is to take share at min prices
What we can do??
We will traverse array
for each iteration:
we will find min elemnt till that iteration i
we will consider min elemnt as buying price as it should be minimum
and elemnt at ith at every iteration will be selling price
we will maintain max profit for every iteration

*/

class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            ans=Math.max(ans,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return ans;
    }
}