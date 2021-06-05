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
           int a[]=new int[n];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           deployk obj=new deployk();
           int ans=obj.solve(n,a);
           System.out.println(ans);
           }
  }
}


class deployk
{
    public int solve(int n,int a[])
    {
        if(n<=2)
            return 0;
        int count=0;
        int del=0;
        int arr[]=new int[n];
        for(int i=1;i<n-1;i++)
        {
            if(a[i]>a[i+1] && a[i]>a[i-1])
            {
                count++;
                arr[i]=1;
            }
            else if(a[i]<a[i+1] && a[i]<a[i-1])
            {
                count++;
                arr[i]=1;
            }
        }
        int some=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==1)
            {
                some++;
                del=Math.max(some,del);
            }
            else
            {
                some=0;
            }
        }
        del=Math.max(some,del);
        if(del<3)
            return count-del;
        return count-3;
    }
}



