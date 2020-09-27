/* package codechef; // don't place package name! */
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
		int t=sc.nextInt();
     	while(t-- >0)
     	{
		  int n=sc.nextInt();
		  int indegree[]=new int[n+1];
		  for(int i=0;i<n-1;i++)
		  {
		      int x=sc.nextInt();
		      int y=sc.nextInt();
		      indegree[y]++;
		  }
        //   deployC obj=new deployC();
        //   int ans=obj.solve(arr,n);
          int ans=0;
        //   for(int i=1;i<=n;i++)
        //   {
        //       if(indegree[i]==0)
        //          ans++;
        //   }
          /*
          alternative solution
          */
          for(int i=1;i<=n;i++)
          {
              if(indegree[i]!=0)
                 ans+=indegree[i]-1;
          }
          System.out.println(ans);
 		}
      }
	}
}
// class deployC
// {
//     public boolean solve(int a[],int n)
//     {
//       int sum=0;
//       for(int i=0;i<n;i++)
//       {
//           sum+=a[i];
//       }
//       if(sum<0)
//          return false;
//       return true;
//     }
    
// }
