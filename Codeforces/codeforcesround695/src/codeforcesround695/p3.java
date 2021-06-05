import java.util.*;
import java.lang.*;
import java.io.*;

public class p3 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
           int n=sc.nextInt();
           int arr[]=new int[n+1];
           for(int i=1;i<=n;i++)
           {
               arr[i]=sc.nextInt();
           }
           deploysome obj=new deploysome();
           int ans=obj.solve(n,arr);
           System.out.println(ans);
        }
      }
  }
    
}
class deploysome
{
    public int solve(int n,int a[])
    {
        int val[]=new int[n+1];
        val[n]=a[n];
        for(int i=n-1;i>=1;i--)
        {
            if(i+a[i]>n)
                val[i]=a[i];
            else
                val[i]=val[i+a[i]]+a[i];
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans=Math.max(ans,val[i]);
        }
        return ans;
    }
    
}
