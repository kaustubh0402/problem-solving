import java.util.*;
import java.lang.*;
import java.io.*;

class chefchess{
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
          deploy obj=new deploy();
          obj.solve(a,n,k);
 	}
      }
        
  }
    
}
class deploy
{
    public void solve(int a[],int n,int k)
    {
        int ans=Integer.MIN_VALUE;
        for(int i =0 ;i <n-1;i++)
          {
              int temp=a[i];
              while(temp<=k)
              {
                 if(temp==k && a[i]>ans)
                 {
                     ans=a[i];
                     break;
                 }
                 temp=temp+a[i];
              }
          }
          if(ans==Integer.MIN_VALUE)
             System.out.println(-1);
          else
             System.out.println(ans);
    }
    
}
