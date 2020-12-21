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
           int arr[]=new int[n];
           for(int i=0;i<n;i++)
           {
               arr[i]=sc.nextInt();
           }
           deploysome obj=new deploysome();
           obj.solve(n,arr);
        }
      }
  }
    
}
class deploysome
{
    public void solve(int n,int a[])
    {
        for(int i=0;i<n;i++)
        {
            System.out.print((long)Math.pow(2,(int)((Math.log(a[i]))/(Math.log(2))))+" ");
        }
        System.out.println();
    }
    
}

/*
another way:
***
Observation:
Here 1 will be always divisible by any number 
so we can place 1 between any two numbers so can all 3 numbers satisfy conition
example 5 1 6
if n numbers then we will place n/2 1 in between 
8 1 6 1 10 1 17 1 16
Now above sequence satisfy conditions
Now question is where to place 1...either at even or odd index or position
SO we will calculate sum of numbers at even position and sum of num at odd pos
Now we will place 1 at even or odd position which have bigger sum

***
class deploysome
{
    public void solve(int n,int a[])
    {
        long sum=0;
	long sumev=0;
	long sumodd=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
	    if((i&1)==0)
		sumev+=a[i];
	    else
		sumodd+=a[i];
        }
        int big=0;
		if(sumodd>sumev)
			big=1;
		for(int i=0;i<n;i++)
		{
			if((i&1)==big)
				System.out.print(a[i]+" ");
			else
				System.out.print(1+" ");
		}
		System.out.println();
    }
    
}
*/

/* 
My trashy code


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
           int arr[]=new int[n];
           for(int i=0;i<n;i++)
           {
               arr[i]=sc.nextInt();
           }
           deploysome obj=new deploysome();
           obj.solve(n,arr);
        }
      }
  }
    
}
class deploysome
{
    public void solve(int n,int a[])
    {
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
        }
        long num=(sum/n);
        for(int i=0;i<n;i++)
        {
            long fake;
            if(a[i]-(a[i]/num)*num>((a[i]/num)+1)*num-a[i])
                fake=((a[i]/num)+1)*num;
            else
                fake=(a[i]/num)*num;
            if(fake==0)
                fake=(num/(num/a[i]));
            if(a[i]%num==0 || num%a[i]==0)
                fake=a[i];
            System.out.print(fake+" ");
        }
        System.out.println();
    }
    
}
*/