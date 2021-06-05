import java.util.*;
import java.lang.*;
import java.io.*;

public class p1 {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    
    public static void main(String[] args) {
           FastReader sc=new FastReader();
           int t=sc.nextInt();
           while(t-- >0)
     	   {
                long n=sc.nextLong();
                deploy obj=new deploy();
                boolean ans=obj.solve(n);
                if(ans==true)
                  System.out.println("YES");
                else
                  System.out.println("NO");
           }
    }
}

class deploy
{
    public boolean solve(long n)
    {
        if(n==1)
            return false;
        if((n&1)==1)
            return true;
        if((n&(n-1))==0)
            return false;
        return true;
    }
    
}


