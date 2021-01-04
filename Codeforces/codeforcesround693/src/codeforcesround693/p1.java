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
                int w=sc.nextInt();
                int h=sc.nextInt();
                int n=sc.nextInt();
                deploy obj=new deploy();
                boolean ans=obj.solve(w,h,n);
                if(ans==true)
                  System.out.println("YES");
                else
                  System.out.println("NO");
           }
    }
}

class deploy
{
    public boolean solve(int w,int h,int n)
    {
        int count=1;
        while((w&1)!=1 || w==0)
        {
            count=count*2;
            w=w>>1;
        }
        while((h&1)!=1 || h==0)
        {
            count=count*2;
            h=h>>1;
        }
        if(count>=n)
            return true;
        return false;
    }
    
}


