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
		 int t=sc.nextInt();
		 while(t-- >0)
		 {
			long n=sc.nextLong();
			deploytemp obj=new deploytemp();
			long ans=obj.solve(n);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public long solve(long n)
    {
        while(true)
        {
            long sum=sum(n);
            long x=gcd(sum,n);
            if(x>1)
               break;
            n++;
        }
        return n;
    }
    
    long gcd(long a,long b)
    {
        if (b==0)
        return a;
      return gcd(b, a % b);
    }
    
    long sum(long n)
    {
        long ans=0;
        while(n!=0)
        {
            ans+=(n%10);
            n=n/10;
        }
        return ans;
    }
}
