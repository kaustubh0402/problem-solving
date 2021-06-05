/* package codechef; // don't place package name! */
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Bowling
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
		  int k=sc.nextInt();
		  int l=sc.nextInt();
          deployA obj=new deployA();
          int ans[]=obj.solve(n,k,l);
          for(int i=0;i<ans.length;i++)
          {
              System.out.print(ans[i]+" ");
          }
          System.out.println();
 		}
      }
	}
}
class deployA
{
    public int[] solve(int n,int k,int l)
    {
        int answer[];
        if(l*k<n)
        {
            answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        if(k==1 && n!=1)
        {
           answer=new int[1];
            answer[0]=-1;
            return answer;   
        }
        answer=new int[n];
        int pl=1;
        for(int i=0;i<n;i++)
        {
            if(pl==k+1)
            pl=1;
            answer[i]=pl;
            pl++;
        }
        return answer;
    }
    
}
