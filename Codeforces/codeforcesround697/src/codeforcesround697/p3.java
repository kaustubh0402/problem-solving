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
           int a=sc.nextInt();
           int b=sc.nextInt();
           int k=sc.nextInt();
           int boy[]=new int[a+1];
           int girl[]=new int[b+1];
           int bp[]=new int[k];
           int gp[]=new int[k];
           for(int i=0;i<k;i++)
           {
               bp[i]=sc.nextInt();
               boy[bp[i]]++;
           }
           for(int i=0;i<k;i++)
           {
               gp[i]=sc.nextInt();
               girl[gp[i]]++;
           }
           deploysome obj=new deploysome();
           long ans=obj.solve(boy,girl,bp,gp,k);
           System.out.println(ans);
        }
      }
  }
    
}
class deploysome
{
    public long solve(int boy[],int girl[],int bp[],int gp[],int k)
    {
        long ans=0;
        for(int i=0;i<k;i++)
        {
            ans+=(((k-1)-(boy[bp[i]]-1)-(girl[gp[i]]-1)));
        }
        return ans/2;
    }
    
}
