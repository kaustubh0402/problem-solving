import java.util.*;
import java.lang.*;
import java.io.*;

public class chefwars {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
           int h=sc.nextInt();
	   int p=sc.nextInt();
          deployAc obj=new deployAc();
          int ans=obj.solve(h,p);
          System.out.println(ans);
 	}
      }
        
  }
    
}
class deployAc
{
    public int solve(int h,int p)
    {
          int sum=0;
          while(p>0)
          {
              sum=sum+p;
              p=p/2;
          }
          if(sum>=h)
              return 1;
          return 0;
    }
    
}
