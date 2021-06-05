import java.util.*;
import java.lang.*;
import java.io.*;

class chef{
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
			String s=sc.next();
			deploytemp obj=new deploytemp();
			obj.solve(n,s);
		 }
	}
}
  
class deploytemp
{
   public void solve(int n,String s)
    {
        int pre[]=new int[n];
        int cnt=0;
        for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                cnt++;
                pre[i]=cnt;
            }
        }
        int max=0;
        int z=0;
        for(int i=0;i<n;i++)
        {
            if(pre[i]==0)
             z++;
            else
             max=Math.max(max,z+pre[i]);
        }
        System.out.println(n-Math.max(max,z));
    }
}
