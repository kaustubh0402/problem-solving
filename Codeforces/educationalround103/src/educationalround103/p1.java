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
                int k=sc.nextInt();
                deploy obj=new deploy();
                int ans=obj.solve(n,k);
                System.out.println(ans);
           }
    }
}

class deploy
{
    public int solve(int n,int k)
    {
        if(n>k)
        {
           if(n%k==0)
               return 1;
           k=((n/k)+1)*k; 
        }
        int ans=k/n;
        int rem=k%n;
        if(k%n==0)
            return ans;
        return ans+1;
    }
    
    
}


