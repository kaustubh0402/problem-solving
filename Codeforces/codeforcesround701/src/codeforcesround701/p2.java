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
           int a[]=new int[n+1];
           for(int i=1;i<=n;i++)
           {
               a[i]=sc.nextInt();
           }
           deployk obj=new deployk();
           int ans=obj.solve(n,a,k);
           System.out.println(ans);
           }
  }
}


class deployk
{
    public int solve(int n,int a[],int k)
    {
        if(1000*n<k)
            return -1;
        int temp=k;
        for(int j=0;j<temp;j++)
        {
            for(int i=1;i<n;i++)
            {
                if(a[i]<a[i+1])
                {
                    a[i]++;
                    k--;
                    if(k<=0)
                        return i;
                    break;
                }
            }
        }
        return -1;
    }
}



