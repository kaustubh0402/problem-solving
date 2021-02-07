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
                String s=sc.next();
                deploy obj=new deploy();
                String ans=obj.solve(s);
                System.out.println(ans);
           }
    }
}

class deploy
{
    public String solve(String s)
    {
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(i%2==0)
            {
                if(curr=='a')
                    ans.append('b');
                else
                    ans.append('a');
            }
            else
            {
                if(curr=='z')
                    ans.append('y');
                else
                    ans.append('z');
            }
        }
        return ans.toString();
    }
    
    
}


