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
