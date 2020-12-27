import java.util.*;
import java.lang.*;
import java.io.*;

class chefweds {
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
           
          deploytemp obj=new deploytemp();
          obj.solve(a,n,k);
 	    }
      }
    }
  }
  
class deploytemp
{
   public void solve(int a[],int n,int k)
    {
       System.out.println();
    }
}
