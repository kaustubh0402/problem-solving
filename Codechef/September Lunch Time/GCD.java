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
		  int arr[]=new int[n+1];
		  for(int i=1;i<=n;i++)
		  {
		      arr[i]=sc.nextInt();
		  }
          deployA obj=new deployA();
          boolean ans=obj.solve(arr,n);
          if(ans==true)
          System.out.println("YES");
          else
          System.out.println("NO");
 		}
      }
	}
}
class deployA
{
    public boolean solve(int a[],int n)
    {
        for(int i=1;i<=n;i++)
        {
            if(a[i]!=i)
            {
                if(i%a[i]!=0)
                  return false;
            }
        }
        return true;
    }
    
}
