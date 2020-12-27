import java.util.*;
import java.lang.*;
import java.io.*;

class THREE{
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
			String inp=sc.next();
			deployB obj=new deployB();
			int ans=obj.solve(inp);
			System.out.println(ans);
		 }
	}
}
  
class deployB
{
   public int  solve(String s)
    {
        int a[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            a[s.charAt(i)-97]++;
        }
        int pair=0;
        int rem=0;
        for(int i=0;i<26;i++)
        {
            pair+=a[i]/2;
            rem+=a[i]%2;
        }
        if(rem>=pair)
          return pair;
        int diff=(pair-rem);
        int ans=rem;
        ans+=(2*diff)/3;
        return ans;
    }
}
