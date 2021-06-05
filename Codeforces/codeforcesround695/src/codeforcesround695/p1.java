import java.util.*;
import java.lang.*;
import java.io.*;

public class p1 {
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
                deploy obj=new deploy();
                obj.solve(n);
           }
    }
}

class deploy
{
    public void solve(int n)
    {
        if(n==1)
        {
            System.out.println("9");
            return;
        }
        if(n==2)
        {
            System.out.println("98");
            return;
        }
        StringBuilder ans=new StringBuilder("989");
        n=n-3;
        int cnt=n/10;
        int rem=n%10;
        String s="0123456789";
        for(int i=0;i<cnt;i++)
        {
            ans.append(s);
        }
        int dum=0;
        for(int i=2;i<=rem+1;i++)
        {
            ans.append(dum);
            dum++;
        }
        System.out.println(ans);
    }
    
}


