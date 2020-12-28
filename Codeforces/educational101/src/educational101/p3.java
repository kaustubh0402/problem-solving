import java.util.*;
import java.lang.*;
import java.io.*;

public class p3 {
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
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           deployp3 obj=new deployp3();
           boolean ans=obj.solve(n,k,a);
           if(ans==true)
               System.out.println("YES");
           else
               System.out.println("NO");
 	}
      }
        
  }
    
}
class deployp3
{
    public boolean solve(int n,int k,int a[])
    {
        int max[]=new int[n];
        int fmn[]=new int[n];
        int fmx[]=new int[n];
        max[0]=a[0]+k;
        max[n-1]=a[n-1]+k;
        for(int i=1;i<n-1;i++)
        {
            max[i]=a[i]+2*k-1;
        }
        fmn[0]=a[0];
        fmn[n-1]=a[n-1];
        fmx[0]=max[0];
        fmx[n-1]=max[n-1];
        for(int i=1;i<n;i++)
        {
            int tmn=(fmn[i-1]-(k-1)<0)?0:fmn[i-1]-(k-1);
            int tmx=fmx[i-1]+(k-1);
            if(tmn>a[i] || tmx<max[i])
                return false;
            fmn[i]=(tmn<a[i])?a[i]:tmn;
            fmx[i]=(tmx>max[i])?max[i]:tmx;
        }
        return true;
    }
    
}
