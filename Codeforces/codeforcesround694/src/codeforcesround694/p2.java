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
           int n=sc.nextInt();
           int x=sc.nextInt();
           ArrayList<Integer> a=new ArrayList<>();
           for(int i=0;i<n;i++)
           {
               a.add(sc.nextInt());
           }
           deployk obj=new deployk();
           long ans=obj.solve(n,x,a);
           System.out.println(ans);
           }
  }
}


class deployk
{
    public long solve(int n,int x,ArrayList<Integer>a)
    {
        long sum=0;
        int i=0;
        int flag=0;
        int cnt=0;
        while(i<a.size())
        {
           if(a.get(i)%x==0 && flag==0)
           {
               a.add(a.get(i)/x);
           }
           else
           {
               flag=1;
           }
           sum+=((a.get(i)*(long)Math.pow(x,cnt)));
           i++;
           cnt=(i/(n));
        }
        return sum;
    }
}



