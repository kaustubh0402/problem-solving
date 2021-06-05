https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
//Problem no : 1491

//Another solution : Sorting

class Solution {
    public double average(int[] salary) {
        double ans=0.0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<salary.length;i++)
        {
            ans=ans+salary[i];
            max=Math.max(salary[i],max);
            min=Math.min(salary[i],min);
        }
        return (ans-max-min)/(salary.length-2);
    }
}