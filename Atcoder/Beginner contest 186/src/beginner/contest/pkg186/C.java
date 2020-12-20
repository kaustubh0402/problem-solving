import java.util.*;
import java.lang.*;
import java.io.*;

public class C {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
          int n=sc.nextInt();
          deployC obj=new deployC();
          obj.solve(n);
      }
        
  }
    
}
class deployC
{
    public void solve(int n)
    {
        int ans=0;
        for(int fir=1;fir<=Math.sqrt(n-1);fir++)
        {
            for(int sec=fir;sec*fir<=n-1;sec++)
            {
                ans++;
            }
        }
        if(ans!=0)
        {
        ans=ans*2;
        ans=ans-(int)Math.sqrt(n-1);
        System.out.println(ans);
        }
        else
            System.out.println(0);
    }
    
}
