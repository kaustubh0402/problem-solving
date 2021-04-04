https://leetcode.com/problems/number-of-longest-increasing-subsequence/
//Problem no : 673

//Following solution is same as Printing all LIS
//But it will give MLE error

class Solution {
    class node
    {
        int i;
        int l;
        node(int index,int len)
        {
            i=index;
            l=len;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int mx=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    mx=Math.max(mx,dp[i]);
                }
            }
        }
        ArrayDeque<node> q=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(dp[i]==mx)
                q.add(new node(i,mx));
        }
        int ans=0;
        while(!q.isEmpty())
        {
            node curr=q.removeFirst();
            if(curr.l==1)
            {
                ans++;
                continue;
            }
            for(int in=0;in<curr.i;in++)
            {
                if(dp[in]==curr.l-1 && nums[in]<nums[curr.i])
                {
                    q.add(new node(in,curr.l-1));
                }
            }
        }
        return ans;
    }
}

//(n^2) dp solution
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int mx=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1)
                    {
                        count[i]+=count[j];
                    }
                    mx=Math.max(mx,dp[i]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
            if(dp[i]==mx)
                ans+=count[i];
        
        return ans;
        
    }
}