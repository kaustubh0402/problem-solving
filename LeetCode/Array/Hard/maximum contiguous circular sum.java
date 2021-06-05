https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/

/*
Explanation:
As we have circular array 


*/

int circularSubarraySum(int a[], int n) {
        if(n==0)
          return 0;
        int max=kadane(a,n);
        if(max<0)
          return max;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            a[i]=-a[i];
        }
        int min=kadane(a,n);
        return Math.max(max,min+sum);
    }
    int kadane(int a[],int n)
    {
        int ans=a[0];
        int sum=a[0];
        for(int i=1;i<n;i++)
        {
            if(sum<0)
              sum=0;
            sum+=a[i];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}