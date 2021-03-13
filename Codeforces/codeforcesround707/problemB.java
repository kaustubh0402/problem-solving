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
			for(int i =0 ;i <n;i++)
			{
				a[i]=sc.nextInt();
			}
			deploytemp obj=new deploytemp();
			int ans[]=obj.solve(n,a);
			for(int i=0;i<n;i++)
			  System.out.print(ans[i]+" ");
			System.out.println();
		 }
	}
}
  
class deploytemp
{
   public int[] solve(int n,int a[])
    {
        int ans[]=new int[n];
        int go=0;
        for(int i=n-1;i>=0;i--)
        {
            go=Math.max(go,a[i]);
            if(go>0)
              ans[i]=1;
            go--;
        }
        return ans;
    }
}