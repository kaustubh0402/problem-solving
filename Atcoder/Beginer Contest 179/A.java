import java.util.*;
import java.lang.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     String inp=sc.next();
     deployA obj=new deployA();
     obj.solve(inp);
 	}
      }
        
  }
    
}
class deployA
{
    public void solve(String inp)
    {
      int l=inp.length();
      StringBuffer ans=new StringBuffer(inp);
      if(inp.charAt(l-1)=='s')
      {
        ans.append("es");
      }
      else
      {
        ans.append("s");
      }
      System.out.println(ans.toString());
    }
    
}
