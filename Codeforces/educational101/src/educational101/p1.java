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
           String a=sc.next();
           deployp1 obj=new deployp1();
           boolean ans=obj.solve(a);
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
    public boolean solve(String s)
    {
        int n=s.length();
        int count=0;
        int flag=0;
        int a=0,b=0;
        for(int i=0;i<n;i++)
        {
            char temp=s.charAt(i);
            if(temp=='?')
            {
                count++;
            }
            if(temp=='(')
            {
                if(flag==0)
                {
                    flag=1;
                }
                else
                {
                    a=count;
                }
            }
            if(temp==')')
            {
                if(flag==0)
                {
                    flag=-1;
                    b=count;
                }
            }
        }
        if(flag==1 && count%2==0)
            return true;
        else if(flag==-1 && b>=1 && (count-a)>=1 && count%2==0)
            return true;
        return false;
    }
    
}
