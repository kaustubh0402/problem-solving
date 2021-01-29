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
                int d=sc.nextInt();
                int a[]=new int[n];
                for(int i=0;i<n;i++)
                {
                    a[i]=sc.nextInt();
                }
                deploy obj=new deploy();
                obj.solve(n,d,a);
           }
    }
}

class deploy
{
    public void solve(int n,int d,int a[])
    {
        int h[]=new int[11];
        for(int i=1;i<n;i++)
        {
            int put=(d*i)%10;
            if(h[put]>d*i || h[put]==0)
            {
                h[put]=(d*i);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]%d==0)
            {
                System.out.println("YES");
                continue;
            }
            if(a[i]>=(d*10))
            {
                System.out.println("YES");
                continue;
            }
            else
            {
                if(h[(a[i]-((((a[i]/10-1))*10)+d))%10]<=a[i] && (h[(a[i]-((((a[i]/10-1))*10)+d))%10]!=0 || (a[i]-((((a[i]/10-1))*10)+d))%10==0))
                    System.out.println("YES");
                else
                    System.out.println("No");
            }
        }
    }
    
    
}


