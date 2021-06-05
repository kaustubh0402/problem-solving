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
	
	
    public static void main(String[] args) {
		 FastReader sc=new FastReader();
		 int t=sc.nextInt();
		 while(t-- >0)
		 {
			long n=sc.nextLong();
			deploytemp obj=new deploytemp();
			boolean ans=obj.solve(n);
			if(ans==true)
			  System.out.println("YES");
			else
			  System.out.println("NO");
		 }
	}
}
  
class deploytemp
{
   public  boolean solve(long n)
    {
        for (long a = 1; a*a*a <n; a++) 
        { 
            long b = (n - (a*a*a)); 
            if (search(1, b, b)) 
                return true; 
        } 
        return false; 
    }
    public static boolean search(long s,long  e, long n) 
    { 
        if (s > e) 
            return false; 
        long mid = s + (e - s) / 2; 
        if (mid==(long)Math.cbrt(n) && ((long)Math.cbrt(n)-Math.cbrt(n)==0) )
            return true; 
        if (mid>(long)Math.cbrt(n)) 
            return search(s, mid - 1, n); 
        return search(mid + 1, e, n); 
    } 
    
}
/*
7
1
2
4
34
35
16
703657519796

*/
