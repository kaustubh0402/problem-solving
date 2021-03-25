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
			int n=sc.nextInt();
			int k=sc.nextInt();
			String s=sc.next();
			deploytemp obj=new deploytemp();
			long ans=obj.solve(n,k,s);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public long solve(int n,int k,String s)
    {
        long ans=0;
        int start=0;
        int end=n-1;
        if(n==1)
          return 1;
        while(start<=end)
        {
            if(s.charAt(start)=='*')
            {
                ans++;
                break;
            }
            start++;
        }
        while(end>start)
        {
            if(s.charAt(end)=='*')
            {
                ans++;
                break;
            }
            end--;
        }
        start++;
        end--;
        int found=start;
        while(start<=end)
        {
            int flag=0;
            int j=0;
            for(int i=found;j<k && start<=end;i++)
            {
                if(s.charAt(i)=='*')
                {
                   found=i+1;
                   flag=1;
                }
                start++;
                j++;
            }
            if(flag==1 && j==k)
            {
              ans++;
              start=found;
            }
        }
        return ans;
    }
}
