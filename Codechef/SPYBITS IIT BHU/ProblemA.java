https://www.codechef.com/SPYB21B/problems/SAVWATER/

import java.util.*;
import java.lang.*;
import java.io.*;

class MyClass{
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
			int h=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int c=sc.nextInt();
			deploytemp obj=new deploytemp();
			obj.solve(h,x,y,c);
		 }
	}
}
  
class deploytemp
{
   public void solve(int h,int x,int y,int c)
    {
        int one=x+(int)(Math.floor(y/2.0));
        int total=h*one;
        if(total<=c)
        {
            System.out.println("YES");
            return;
        }
        else
        {
            System.out.println("NO");
            return;
        }
    }
}
