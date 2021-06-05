import java.util.*;
import java.lang.*;
import java.io.*;

public class chefweds {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
           int n=sc.nextInt();
           int k=sc.nextInt();
	   int a[]=new int[n];
           
	   for(int i =0 ;i <n;i++)
	   {
	     int x;
	     x=sc.nextInt();
             a[i]=x;
           }
           
          deploywed obj=new deploywed(n);
          obj.solve(a,n,k);
 	}
      }
        
  }
    
}
class deploywed
{
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    int dp[];
    deploywed(int num)
    {
        dp=new int[num];
        Arrays.fill(dp,-1);
    }
    public void solve(int a[],int n,int k)
    {
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(a[i]))
            {
                if(k<=h.get(a[i]))
                {
                    cost+=k;
                    h.put(a[i],1);
                }
                else
                {
                    cost=cost+1;
                    h.put(a[i],h.get(a[i])+1);
                }
            }
            else
            {
                h.put(a[i],1);
            }
        }
        System.out.println(cost);
    }
    
}
