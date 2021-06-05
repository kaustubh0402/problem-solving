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
           String a=sc.next();
           String b=sc.next();
           int red=0,blue=0;
           for(int i=0;i<n;i++)
           {
               if(a.charAt(i)<b.charAt(i))
                   blue++;
               else if(a.charAt(i)>b.charAt(i))
                   red++;
           }
           if(blue>red)
               System.out.println("BLUE");
           else if(blue<red)
               System.out.println("RED");
           else
               System.out.println("EQUAL");
        }
      }
  }
}
