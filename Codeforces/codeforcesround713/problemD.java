import java.util.*;
import java.lang.*;
import java.io.*;

public class MyClass{
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
			int a[]=new int[n+2];
			for(int i=0;i<n+2;i++)
			  a[i]=sc.nextInt();
			deploytemp obj=new deploytemp();
			obj.solve(a,n);
		 }
	}
}
  
class deploytemp
{
   public void solve(int a[],int m)
    {
        long sum=0;
        int n=m+2;
        int mx1=Integer.MIN_VALUE;
        int mx2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            if(a[i]>=mx1)
            {
                mx2=mx1;
                mx1=a[i];
            }
            else if(a[i]>=mx2)
            {
                mx2=a[i];
            }
        }
        long sm=sum-mx1-mx2;
        long sm1=sum-mx1;
        long sm2=sum-mx2;
        if(sm==mx1 || sm==mx2)
        {
            print(a,n,mx1,mx2);
            return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(sm-a[i]+mx1==mx2)
            {
                print(a,n,mx2,a[i]);
                return;
            }
            else if(sm+-a[i]+mx2==mx1)
            {
                print(a,n,mx1,a[i]);
                return;
            }
        }
        System.out.println(-1);
    }
    
    void print(int a[],int n,int x1,int x2)
    {
        int flag1=0;
        int flag2=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==x1 && flag1==0)
            {
                flag1=1;
                continue;
            }
            else if(a[i]==x2 && flag2==0)
            {
                flag2=1;
                continue;
            }
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
