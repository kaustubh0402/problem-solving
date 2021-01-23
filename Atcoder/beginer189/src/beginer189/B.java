import java.util.*;
import java.lang.*;
import java.io.*;

public class B {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int x=sc.nextInt();
     long total=0;
     int ans=0;
     int i=0;
     int flag=0;
     for(i=0;i<n;i++)
     {
         int v=sc.nextInt();
         int p=sc.nextInt();
         total+=(v*(p/100));
         ans++;
         if(total>x)
         {
             System.out.println(ans);
             flag=1;
             break;
         }
     }
//     System.out.println(total);
     if(flag==0)
         System.out.println(-1);
    }
}