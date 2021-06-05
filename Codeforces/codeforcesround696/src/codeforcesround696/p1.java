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
                int n=sc.nextInt();
                String s=sc.next();
                deploy obj=new deploy();
                obj.solve(n,s);
           }
    }
}

class deploy
{
    public void solve(int n,String s)
    {
        StringBuilder ans=new StringBuilder();
        int one=1,two=1,zero=1;
        char prev=s.charAt(0);
        ans.append('1');
        for(int i=1;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='1')
            {
                if(prev=='1' && ans.charAt(ans.length()-1)=='1')
                    ans.append('0');
                else
                    ans.append('1');
            }
            else
            {
                if((prev=='0' && ans.charAt(ans.length()-1)=='1') || (prev=='1' && ans.charAt(ans.length()-1)=='0') )
                    ans.append('0');
                else
                    ans.append('1');
            }
            prev=c;
        }
        System.out.println(ans);
    }
    
}


