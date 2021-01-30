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
           while(t-->0)
           {
           int n=sc.nextInt();
           int k=sc.nextInt();
           long a[]=new long[n];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           deployk obj=new deployk();
           long ans=obj.solve(n,k,a);
           System.out.println(ans);
           }
  }
}


class deployk
{
    public long solve(int n,int k,long a[])
    {
        long pre[]=new long[n];
        pre[0]=a[0];
        for(int i=1;i<n;i++)
            pre[i]=pre[i-1]+a[i];
        long ans=0;
        long temp=0;
        for(int i=1;i<n;i++)
        {
            long some=pre[i]-a[i]+ans;
            if((a[i]*100.0/(double)some)<=k)
                continue;
            ans+=(long)Math.ceil((a[i]*100.0/(double)k)-(some));
        }
        return ans;
    }
}



