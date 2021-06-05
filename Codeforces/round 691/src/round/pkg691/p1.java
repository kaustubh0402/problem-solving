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
           int n=sc.nextInt();
           int m=sc.nextInt();
           long a[]=new long[n];
           long b[]=new long[m];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextLong();
           }
           for(int i=0;i<m;i++)
           {
               b[i]=sc.nextLong();
           }
           deployp1 obj=new deployp1();
           obj.solve(n,m,a,b);
        
  }
    
}
class deployp1
{
    long so,x,y;
    long gcd(long a,long b)
    {
        if(b==0)
        {
            so=a;
            x=1;
            y=0;
        }
        else
        {
            gcd(b,a%b);
            long temp=x;
            x=y;
            y=temp-(a/b)*y;
            
        }
        return so;
    }
    public void solve(int n,int m,long a[],long b[])
    {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<m;i++)
        {
            long first=b[i];
            long result=a[0]+first;
            int j;
            for(j=1;j<n;j++)
            {
                result=gcd(result,a[j]+first);
                if(result==1)
                {
                    ans.append(1+" ");
                    break;
                }
            }
            if(j==n)
              ans.append(result+" ");
        }
        System.out.println(ans);
    }
    
}
