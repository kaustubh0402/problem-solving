import java.util.*;
import java.lang.*;
import java.io.*;

public class p2 {
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
           while(t-->0)
           {
           int d=sc.nextInt();
           deployk obj=new deployk();
           long ans=obj.solve(d);
           System.out.println(ans);
           }
  }
}


class deployk
{
    static boolean isPrime(long n)  
    {   
        if (n <= 1) return false;  
        if (n <= 3) return true;  
           
        if (n % 2 == 0 || n % 3 == 0) return false;  
          
        for (int i = 5; i * i <= n; i = i + 6)  
            if (n % i == 0 || n % (i + 2) == 0)  
            return false;  
          
        return true;  
    }  
    public long solve(int d)
    {
        long sec=1+d;
        boolean found = false;   
        while (!found)  
        {        
            if (isPrime(sec))  
                found = true; 
            sec++;
        }  
        sec=sec-1;
        long third=sec+d;
        found=false;
        while (!found)  
        {        
            if (isPrime(third))  
                found = true; 
            third++;
        }  
        third=third-1;
        return third*sec;
    }
}



