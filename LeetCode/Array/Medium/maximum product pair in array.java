https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc=new Scanner(System.in);
	     int t=sc.nextInt();
	     while(t-- >0)
	     {
	         int n=sc.nextInt();
	         int a[]=new int[n];
	         for(int i=0;i<n;i++)
	         {
	             a[i]=sc.nextInt();
	         }
	         HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
    	     for(int i=0;i<n;i++)
    	     {
    	         if(m.containsKey(a[i]))
    	            m.put(a[i],m.get(a[i])+1);
    	         else
    	            m.put(a[i],1);
    	     }
    	     Arrays.sort(a);
    	     Solve obj=new Solve();
    	     int ans=obj.deploy(n,a,m);
    	     System.out.println(ans);
	     }
	 }
}
class Solve
{
    int deploy(int n,int a[],HashMap<Integer,Integer>m)
    {
        for(int i=n-1;i>=0;i--)
    	     {
    	         for(int j=0;j<i && a[j]<=Math.sqrt(a[i]);j++)
    	         {
    	             if(a[i]%a[j]==0)
    	             {
    	                 int res=a[i]/a[j];
    	                 if(res==a[j])
    	                 {
    	                     if(res==a[i] && m.get(res)>2)
    	                       return a[i];
    	                     else if(m.get(res)>1)
    	                       return a[i];
    	                 }
    	                 else
    	                 {
    	                     if(res==a[i] && m.get(res)>1 && m.containsKey(a[j]))
    	                       return a[i];
    	                     else if(a[j]==a[i] && m.get(a[j])>1 && m.containsKey(res))
    	                       return a[i];
    	                     else if((a[j]!=a[i] && a[i]!=res) && m.containsKey(a[j]) && m.containsKey(res))
    	                       return a[i];
    	                 }
    	             }
    	         }
    	     }
    	return -1;
    }
}