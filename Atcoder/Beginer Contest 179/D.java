//Incomplete solution

import java.util.*;
import java.lang.*;
import java.io.*;

public class D {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
          long n=sc.nextLong();
          int x=sc.nextInt();
          int m=sc.nextInt();
          deployE obj=new deployE();
          obj.solve(n,x,m);
      }
        
  }
    
}
class deployE
{
    public void solve(long n,int x,int m)
    {
        long sum=x;
        long prev=x;
        for(long i =0 ;i<n-1;i++)
        {
            prev=((prev%m)*(prev%m))%m;
            sum=sum+prev;
//            System.out.println(prev);
        }
        System.out.println(sum);
    }
    
}
