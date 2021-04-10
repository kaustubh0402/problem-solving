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
			int a[]=new int[n];
			for(int i =0 ;i <n;i++)
			{
				int x;
				x=sc.nextInt();
				a[i]=x;
			} 
			deploytemp obj=new deploytemp();
			int ans=obj.solve(a,n);
			  System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public int solve(int a[],int n)
    {
        if(a[0]!=a[1] && a[0]!=a[2])
          return 1;
		for(int i=1;i<n-1;i++)
		{
		    if(a[i]!=a[i+1] && a[i]!=a[i-1])
		      return i+1;
		}
		return n;
    }
}
