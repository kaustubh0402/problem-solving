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
			int a[]=new int[n];
			for(int i =0 ;i <n;i++)
			{
				int x;
				x=sc.nextInt();
				a[i]=x;
			} 
			deploytemp obj=new deploytemp();
			obj.solve(a,n);
		 }
	}
}
  
class deploytemp
{
   public void solve(int a[],int n)
    {
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(Math.abs(a[i])%2==0)
              cnt1++;
            else
              cnt2++;
        }
       System.out.println(Math.min(cnt1,cnt2));
    }
}
