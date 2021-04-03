import java.util.*;
import java.lang.*;
import java.io.*;

public class MyClass{
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
			String s=sc.next();
			deploytemp obj=new deploytemp();
			obj.solve(s);
		 }
	}
}
  
class deploytemp
{
   public void solve(String s)
    {
        int n=s.length();
        int count=0;
        int start=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='a')
              count++;
        }
        if(count==n)
        {
            System.out.println("NO");
            return;
        }
        
            int index=n;
            while(start<=n-1)
            {
                if(s.charAt(start)=='a')
                {
                    start++;
                    index--;
                }
                else
                {
                    break;
                }
            }
            if(index<0)
            {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            StringBuilder temp=new StringBuilder(s);
            temp.insert(index,'a');
            System.out.println(temp);
    }
}
