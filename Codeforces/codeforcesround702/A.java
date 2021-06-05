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
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            int min=Math.min(a[i],a[i+1]);
            int max=Math.max(a[i],a[i+1]);
            while((double)max/min>2)
            {
                int flag=0;
                if((max&1)==1)
                  flag=1;
                max=max/2+flag;;
                ans++;
            }
        }
        return ans;
    }
}
