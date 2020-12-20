import java.util.*;
import java.lang.*;
import java.io.*;

public class p3 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
           int n=sc.nextInt();
           deployso obj=new deployso();
           long ans=obj.solve(n);
           System.out.println(ans);
      }
  }
    
}
class deployso
{
    public long solve(int n)
    {
        if(n==1 || n==2)
            return 4;
        if((n&1)==0)
            return ((n/2+1))*(n/2+1);
        return ((n-1)/2)*8+4;
    }
    
}
