import java.util.*;
import java.lang.*;
import java.io.*;

public class p4 {
    
    
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
           int n=sc.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           deployp1 obj=new deployp1();
           obj.solve(n,a);
           }
  }
    
}
class deployp1
{
    public void solve(int n,int a[])
    {
        Arrays.sort(a);
        long al=0;
        for(int i=n-1;i>=0;i--)
        {
            if(((n-i-1)%2)==0)
            {
                if((a[i]%2)==0)
                    al+=a[i];
            }
            else
            {
                if((a[i]%2)==1)
                    al-=a[i];
            }
        }
        if(al>0)
                System.out.println("Alice");
        else if(al<0)
                System.out.println("Bob");
        else
                System.out.println("Tie");
    }
    
}
