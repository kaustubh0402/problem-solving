import java.util.*;
import java.lang.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     String n=sc.next();
     if(n.charAt(0)==n.charAt(1)&& n.charAt(1)==n.charAt(2))
         System.out.println("Won");
     else
         System.out.println("Lost");
    }
}