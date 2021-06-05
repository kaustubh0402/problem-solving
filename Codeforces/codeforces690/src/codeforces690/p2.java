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
	   String inp=sc.next();
           deploy1 obj=new deploy1();
           boolean ans=obj.solve(n,inp);
           if(ans==true)
               System.out.println("YES");
           else
               System.out.println("NO");
 	}
      }
        
  }
    
}
class deploy1
{
    public boolean solve(int n,String s)
    {
        StringBuilder find=new StringBuilder("2020");
        for(int j=0;j<n;j++)
        {
            int i=j;
            if(s.charAt(i)=='2')
            {
                find.deleteCharAt(0);
                i++;
                if(i==n-3 && s.charAt(i)=='0')
                {
                    find.deleteCharAt(0);
                    i++;
                    if(i==n-2 && s.charAt(i)=='2')
                    {
                        find.deleteCharAt(0);
                        i++;
                        if(i==n-1 && s.charAt(i)=='0')
                            return true;
                        else if(s.substring(i).lastIndexOf(find.toString())+find.length()-1==n-1-i && s.substring(i).lastIndexOf(find.toString())!=-1)
                            return true;
                   
                    }
                    else if(s.substring(i).lastIndexOf(find.toString())+find.length()-1==n-1-i && s.substring(i).lastIndexOf(find.toString())!=-1)
                            return true;
                    
                }
                else if(s.substring(i).lastIndexOf(find.toString())+find.length()-1==n-1-i && s.substring(i).lastIndexOf(find.toString())!=-1)
                            return true;
           
            }
            find=new StringBuilder("2020");
        }
        return false;
    }
    
}
