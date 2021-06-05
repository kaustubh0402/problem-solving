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
           int arr[]=new int[n];
           for(int i=0;i<n;i++)
           {
               arr[i]=sc.nextInt();
           }
           deployp1 obj=new deployp1();
           obj.solve(n,arr);
 	}
      }
        
  }
    
}
class deployp1
{
    public void solve(int n,int a[])
    {
        int left=0,right=n-1;
        while(left<right)
        {
            System.out.print(a[left]+" "+a[right]+" ");
            left++;
            right--;
        }
        if(left==right)
            System.out.print(a[left]);
        System.out.println();
    }
    
}
