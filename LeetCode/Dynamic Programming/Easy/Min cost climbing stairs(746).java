https://leetcode.com/problems/min-cost-climbing-stairs/
//Problem no : 746

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int f1=cost[0],f2=cost[1];
        for(int i=2;i<n;i++)
        {
            int var=cost[i]+Math.min(f1,f2);
            f1=f2;
            f2=var;
        }
        return Math.min(f1,f2);
    }
}