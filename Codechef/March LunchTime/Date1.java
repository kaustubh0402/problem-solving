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
			int a=sc.nextInt();
			int y=sc.nextInt();
			int x=sc.nextInt();
			deploytemp obj=new deploytemp();
			obj.solve(a,y,x);
		 }
	}
}
  
class deploytemp
{
   public void solve(int a,int y,int x)
    {
        int t=0;
        long count=1;
        int start=a-y+1;
        if(start<=0)
        {
          start=1;
        }
        else
        {
            count--;
        }
        count+=(a-start+1)*(long)x;
        System.out.println(count);
    }
}
