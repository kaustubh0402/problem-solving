import java.util.*;
import java.lang.*;
import java.io.*;

public class problem{
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
		 int test=sc.nextInt();
		 while(test-- >0)
		 {
			int n=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			for(int i =0 ;i <n;i++)
			{
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
			}
			int t[]=new int[n];
			for(int i =0 ;i <n;i++)
			{
				t[i]=sc.nextInt();
			} 
			deploytemp obj=new deploytemp();
			int ans=obj.solve(n,a,b,t);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public int solve(int n,int a[],int b[],int t[])
    {
        int curr=a[0]+t[0];
        for(int i=0;i<n-1;i++)
        {
            int wait=(int)Math.ceil((b[i]-a[i])/2.0);
            curr=Math.max((curr+wait),b[i]);
             curr+=(a[i+1]-b[i]+t[i+1]);
        }
        return curr;
    }
}