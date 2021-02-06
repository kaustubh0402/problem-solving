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
                int x=sc.nextInt();
                int y=sc.nextInt();
                String s=sc.next();
                deploy obj=new deploy();
                boolean ans=obj.solve(x,y,s);
                if(ans==true)
                    System.out.println("YES");
                else
                    System.out.println("NO");
           }
    }
}

class deploy
{
    public boolean solve(int x,int y,String s)
    {
        int n=s.length();
        int u=0,d=0,r=0,l=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='D')
                d++;
            else if(c=='L')
                l++;
            else if(c=='U')
                u++;
            else if(c=='R')
                r++;
        }
        boolean xok=false;
        boolean yok=false;
        if(x<=0 && l>=Math.abs(x))
            xok=true;
        if(x>=0 && r>=Math.abs(x))
            xok=true;
        if(y<=0 && d>=Math.abs(y))
            yok=true;
        if(y>=0 && u>=Math.abs(y))
            yok=true;
        return (xok&yok);
        
    }
    
    
}


