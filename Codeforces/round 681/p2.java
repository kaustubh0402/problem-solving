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
           int a=sc.nextInt();
           int b=sc.nextInt();
	   String inp=sc.next();
           char x[]=inp.toCharArray();
           deploy1 obj=new deploy1();
           obj.solve(a,b,x);
 	}
      }
        
  }
    
}
class deploy1
{
    public void solve(int a,int b,char s[])
    {
        int cost=0;
        int i=0;
        int cnt=0;
        while(i<=s.length-1)
        {
            int index1=0;
            if(s[i]=='1')
            {
                while(i<=s.length-1 && s[i]!='0')
                {
                    i++;
                }
                index1=i;
                while(i<=s.length-1 && s[i]!='1')
                {
                    i++;
                }
//                System.out.print(index1+" "+i+" n ");
                if(s[s.length-1]=='0' && i==s.length)
                    continue;
                if(((i-index1)*b)<=a)
                {
                    cost+=((i-index1)*b);
                }
                else
                {
                    cost+=a;
                    
                }
//                System.out.print(cost+" ");
            }
            else
            {
                i++;
                cnt++;
            }
        }
        if(cnt==s.length)
            a=0;
        System.out.println(cost+a);
    }
    
}
