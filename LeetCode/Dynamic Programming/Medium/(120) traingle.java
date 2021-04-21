https://leetcode.com/problems/triangle/
//Problem no : 120

//Normal recursive optimized dp code
//calling ith element or i+1 element of next row whichever is minimum.
class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new int[n][n];
        for(int i=0;i<n;i++)
          Arrays.fill(dp[i],-1);
        return helper(triangle,0,0);
    }
    
    int helper(List<List<Integer>> t,int index,int r)
    {
        if(r==t.size())
            return 0;
        if(dp[r][index]!=-1)
            return dp[r][index];
        int ans1=helper(t,index,r+1)+t.get(r).get(index);
        int ans2=helper(t,index+1,r+1)+t.get(r).get(index);
        return dp[r][index]=Math.min(ans1,ans2);
    }
}

/*
Space optimization:
Now if we look at the call 
consider for rows and col (or position)
one thing is sure that position in row can be anything
so we cannot restrict position

Now if we look at row (bottom up approach)
we know that for every call we are taking result from i+1 row
i.e previos result is dependent on i+1 state only i.e only one next row required not complete traingle
now how we will find next row result
we will create one dummy row let say temp initailly filled with last row (bottom up approach)
temp will hold data of next row for current call
after one row we will load data of dp( i.e current row) to temp which will act as next row for next call
*/
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        int dp[]=new int[n];
        int temp[]=new int[n];
        for(int i=0;i<n;i++)
            temp[i]=t.get(n-1).get(i);
        for(int row=n-2;row>=0;row--)
        {
            for(int col=t.get(row).size()-1;col>=0;col--)
            {
                dp[col]=Math.min(temp[col+1],temp[col])+t.get(row).get(col);
            }
            temp=dp.clone();
        }
        return temp[0];
    }
}