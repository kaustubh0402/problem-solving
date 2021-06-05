import java.util.*;
import java.lang.*;
import java.io.*;

public class chef{
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
	
	static long profit=Long.MIN_VALUE;
	static long mx=Long.MIN_VALUE;
	static long mn=Long.MAX_VALUE;
    public static void main(String[] args) {
		 FastReader sc=new FastReader();
			int n=sc.nextInt();
			int k=sc.nextInt();
			int a[][]=new int[n][3];
			for(int i=0;i<n;i++)
			{
			   a[i][0]=sc.nextInt();
			   a[i][1]=sc.nextInt();
			   a[i][2]=sc.nextInt();
			}
			long lmin=a[0][0];
	        long lmax=a[0][1];
			solve(n,k,a,0,0,lmin,lmax);
			System.out.println(profit);
	}
	
	public static void solve(int n,int k,int a[][],int index,long sum,long lmin,long lmax)
    {
        if(index==n)
          return;
        long one=0;
        long two=0;
        if(lmin>mn && mn!=Long.MAX_VALUE)
        {
              one=lmin-mn;
              mn=lmin;
        }
        if(lmax>mx && mx!=Long.MIN_VALUE)
        {
              two=lmax-mx;
              mx=lmax;
        }
        if(mn==Long.MAX_VALUE)
        {
            one=0;
            two=lmax-lmin;
            mn=lmin;
            mx=lmax;
        }
        profit=Math.max(profit,sum);
        solve(n,k,a,index+1,sum-(k*one)-(k*two)+a[index][2],a[index][0],a[index][1]);
        solve(n,k,a,index+1,sum,lmin,lmax);
    }
}
