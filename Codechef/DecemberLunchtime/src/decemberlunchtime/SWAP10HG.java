import java.util.*;
import java.lang.*;
import java.io.*;

class SWAP10HG{
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
			String p=sc.next();
			deployA obj=new deployA();
			int ans=obj.solve(n,s,p);
			if(ans==1)
			  System.out.println("Yes");
			else
			  System.out.println("No");
		 }
	}
}
  
class deployA
{
   public int solve(int n,String s,String p)
    {
        int pone=0,sone=0;
        int len=s.length();
        int carry=0;
        for(int i=0;i<len;i++)
        {
            char pc=p.charAt(i);
            char sc=s.charAt(i);
            if(sc=='1')
               sone++;
            if(pc=='1')
               pone++;
            if(pc!=sc && sc=='0')
            {
                if(carry==0)
                   return 0;
                else
                  carry--;
            }
            else if(pc!=sc && sc=='1')
              carry++;
        }
        if(pone==sone)
          return 1;
        return 0;
    }
}
