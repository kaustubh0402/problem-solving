import java.util.*;
import java.lang.*;
import java.io.*;

public class example {
    
    
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
		   int start=1,end=n;
		   int mid=(start+end)/2;
		   int l,r,val;
		   while(start<end)
		   { 
	          mid=(start+end)/2;
              System.out.println("? "+mid);
              System.out.flush();
              val=sc.nextInt();
              if(mid==1)
                l=10000000;
              else
              {
                  System.out.println("? "+(mid-1));
                  System.out.flush();
                  l=sc.nextInt();
              }
              if(mid==n)
                r=10000000;
              else
              {
                  System.out.println("? "+(mid+1));
                  System.out.flush();
                  r=sc.nextInt();
              }
              if(val<Math.min(l,r))
              {
                  System.out.println("! "+mid);
                  System.out.flush();
                  return;
              }
              if(l<r)
                end=mid-1;
              else
                start=mid+1;
		   }
    }
  }

