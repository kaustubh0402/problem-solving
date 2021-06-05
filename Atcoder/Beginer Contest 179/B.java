import java.util.*;
import java.lang.*;
import java.io.*;

public class B {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
     	for(int i=0;i<n;i++)
     	{
           arr[i][0]=sc.nextInt();
	   arr[i][1]=sc.nextInt();  
 	}
        deployB obj=new deployB();
          boolean ans=obj.solve(arr,n);
          if(ans==true)
          System.out.println("Yes");
          else
          System.out.println("No");  
      }
        
  }
    
}
class deployB
{
    public boolean solve(int a[][],int n)
    {
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(a[i][0]==a[i][1])
            {
                cnt++;
            }
            else
                cnt=0;
            if(cnt==3)
                return true;
        }
        return false;
    }
    
}
