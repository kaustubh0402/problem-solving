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
           int n=sc.nextInt();
           deployp1 obj=new deployp1();
           obj.solve(n);
 	}
      }
        
  }
    
}
class deployp1
{
    public void solve(int n)
    {
        int start=2*n;
        for(int i=0;i<n;i++)
        {
            System.out.print(start+" ");
            start+=2;
        }
        System.out.println();
    }
    
}
