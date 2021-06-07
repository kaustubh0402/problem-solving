//problem no : 1889
https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/1257592/JAVA-Binary-search-prefix-sum-with-commented-code


class Solution {
    public int minWastedSpace(int[] p, int[][] b) {
        int n=p.length;
        int m=b.length;
        int mod=1000000007;
        
        //Sort array to apply binary Search
        //Remember we have to apply binary search on package
        //If binary search apply on box it will give TLE
        Arrays.sort(p);
        
        
        //We will also have to sort matrix of package 
        //so that we can terminate and find minimum package
        for(int i=0;i<m;i++)
            Arrays.sort(b[i]);
        
        
        //prefix array to access sum directly 
        long pre[]=new long[n+1];
        for(int i=1;i<=n;i++)
            pre[i]=pre[i-1]+p[i-1];
        
        
        //Final minimum answer will be stored in waste variable
        long waste=Long.MAX_VALUE;
        
        
        //Outer loop for iterate over all boxes to find which box to select
        for(int i=0;i<m;i++)
        {
            // prev variable will be used to store index till we have found suitable value from current box
            int prev=0;
            //ans will store value of current minium waste
            long ans=0;
            //Inner loop will iterate over all boxes value
            //will find index till which current value from box will be considered for holding package
            for(int j=0;j<b[i].length;j++)
            {
                int index=binary(p,b[i][j]);
                //Suppose box is less than package then we cannot hold package in box
                if(index==-1)
                    continue;
                //here is our main logic
                //form previou index to current index we will find prefix sum
                //and subtract prefix sum from (total package)*box value
                //total package will be index-prev+1 
                ans=ans+((long)b[i][j]*(index-prev+1))-(pre[index+1]-pre[prev]);
                //update our previou index
                prev=index+1;
                //This condition ensure that all packages are placed in boxes
                if(prev>=n)
                    break;
            }
            if(prev>=n)
                waste=Math.min(waste,ans);
        }
        
        return waste==Long.MAX_VALUE?-1:(int)(waste%mod);
    }
    
    //Find index till which we can use current box of value 'val' for packages
    int binary(int a[],int val)
    {
        int start=0;
        int end=a.length-1;
        int ans=-1;
        while(start<=end)
        {
            int mid=(start+end)>>1;
            if(a[mid]<=val)
            {
                ans=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return ans;
    }
}



/*
Without prefix sum
We have notice that all pacakges are utilized  (package sum is constant)
at end we have to  find total difference in box and actual package
so we dont have to maintain separate prefix sum 
we can subtract total sum of package from total box that we have used
*/

class Solution {
    public int minWastedSpace(int[] p, int[][] b) {
        int n=p.length;
        int m=b.length;
        int mod=1000000007;
        
        //Sort array to apply binary Search
        Arrays.sort(p);
        //prefix array to access sum directly
        
        for(int i=0;i<m;i++)
            Arrays.sort(b[i]);
        
        long sum=0;
        for(int i=0;i<n;i++)
            sum=sum+p[i];
        
        long waste=Long.MAX_VALUE;
        
        for(int i=0;i<m;i++)
        {
            int prev=0;
            long ans=0;
            for(int j=0;j<b[i].length;j++)
            {
                int index=binary(p,b[i][j]);
                if(index==-1)
                    continue;
                ans=ans+((long)b[i][j]*(index-prev+1));
                prev=index+1;
                if(prev>=n)
                    break;
            }
            if(prev>=n)
                waste=Math.min(waste,ans);
        }
        
        return waste==Long.MAX_VALUE?-1:(int)((waste-sum)%mod);
    }
    
    int binary(int a[],int val)
    {
        int start=0;
        int end=a.length-1;
        int ans=-1;
        while(start<=end)
        {
            int mid=(start+end)>>1;
            if(a[mid]<=val)
            {
                ans=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return ans;
    }
}
