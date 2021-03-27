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
			for(int i=0;i<n;i++)
			  a[i]=sc.nextInt();
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
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=i+1;j<n;j++)
            {
                if(a[i]==a[j])
                  count++;
                else if(a[i]<a[j])
                  break;
            }
            ans[i]+=count;
        }
        
        for(int i=n-1;i>=0;i--)
        {
            int count=0;
            for(int j=i-1;j>=0;j--)
            {
                if(a[i]==a[j])
                  count++;
                else if(a[i]<a[j])
                  break;
            }
            ans[i]+=count;
        }
        return ans;
    }
}
