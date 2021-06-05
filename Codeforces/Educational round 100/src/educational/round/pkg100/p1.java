import java.util.*;
import java.lang.*;
import java.io.*;

public class p1 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
           int a=sc.nextInt();
           int b=sc.nextInt();
           int c=sc.nextInt();
           deployp1 obj=new deployp1();
           boolean ans=obj.solve(a,b,c);
           if(ans==true)
               System.out.println("YES");
           else
               System.out.println("NO");
 	}
      }
        
  }
    
}
class deployp1
{
    public boolean solve(int a,int b,int c)
    {
        int sum=a+b+c;
        int small=Math.min(a,Math.min(b,c));
        if(sum>=7 && sum%9==0 && small>=(sum/9))
            return true;
        return false;
    }
    
}
