/*
Observation:
for any number , Highest power of 2 which is less than n and nearer to n
example for n==29 -->pow of 2 is 16
            n==13 -->pow of 2 is 8
From above we notice than pow of 2 will be always greater than n/2..
So it will satisfy our all condition 
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class p2 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
           int n=sc.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           int m=sc.nextInt();
           int b[]=new int[m];
           for(int i=0;i<m;i++)
           {
               b[i]=sc.nextInt();
           }
           deploysome obj=new deploysome();
           obj.solve(n,a,m,b);
        }
      }
  }
    
}
class deploysome
{
    public void solve(int n,int a[],int m,int b[])
    {
        int sum1=0,sum2=0;
        int mx1=0,mx2=0;
        for(int i=0;i<n;i++)
        {
            sum1+=a[i];
            mx1=Math.max(sum1,mx1);   
        }
        for(int i=0;i<m;i++)
        {
            sum2+=b[i];
            mx2=Math.max(sum2,mx2);
        }
        System.out.println(mx1+mx2);
    }
    
}

