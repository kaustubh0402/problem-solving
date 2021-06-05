import java.util.*;
import java.lang.*;
import java.io.*;

public class p2 {
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
                int two=0;
                int one=0;
                for(int i=0;i<n;i++)
                {
                    int x=sc.nextInt();
                    if(x==1)
                        one++;
                    else
                        two++;
                }
                deployk obj=new deployk();
                boolean ans=obj.solve(n,one,two);
                if(ans==true)
                  System.out.println("YES");
                else
                  System.out.println("NO");
           }
    }
}

class deployk
{
    public boolean solve(int n,int one,int two)
    {
        if((two&1)==0 && (one &1)==0)
                return true;
        if((two&1)==1 && (one &1)==0 && one!=0)
            return true;
        return false;
    }
}


