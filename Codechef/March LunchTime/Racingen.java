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
			int x=sc.nextInt();
			int r=sc.nextInt();
			int m=sc.nextInt();
			deploytemp obj=new deploytemp();
			boolean ans=obj.solve(x,r,m);
			if(ans==true)
			  System.out.println("YES");
			else
			  System.out.println("NO");
		 }
	}
}
  
class deploytemp
{
   public boolean solve(int x,int r,int m)
    {
        long rsec=(long)r*60;
        long msec=(long)m*60;
        if(msec<rsec)
          return false;
        if(rsec<=x)
          return true;
        long check=rsec-x;
        long need=msec-x;
        if(need>=2*check)
          return true;
        return false;
    }
}
