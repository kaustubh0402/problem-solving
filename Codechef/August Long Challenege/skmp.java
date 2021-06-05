import java.util.*;
import java.lang.*;
import java.io.*;

 class skmp {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
	   int a[]=new int[26];
           String s=sc.next();
           String p=sc.next();
	   for(int i =0 ;i <s.length();i++)
	   {
             a[s.charAt(i)-'a']+=1;
           }
           for(int i=1;i<p.length();i++)
           {
               a[p.charAt(i)-'a']-=1;
           }
          deployskmp obj=new deployskmp();
          obj.solve(a,p);
 	}
      }
        
  }
    
}
class deployskmp
{
    public void solve(int a[],String p)
    {
        for(int i =0 ;i <26;i++)
	{
            if(a[i]!=-0)
            {
                for(int j=0;j<a[i];j++)
                {
                    System.out.print((char)('a'+i));
                }
                if(p.charAt(0)-'a'==i)
                    for(int k=1;k<p.length();k++)
                    System.out.print(p.charAt(k));
            }
        }
        System.out.println();
    }
    
}
