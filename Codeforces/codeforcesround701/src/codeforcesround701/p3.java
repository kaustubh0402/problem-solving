import java.util.*;
import java.lang.*;
import java.io.*;

public class p3 {
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
           int m=sc.nextInt();
           int a[]=new int[n];
           int b[]=new int[n];
           int c[]=new int[m];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           for(int i=0;i<n;i++)
           {
               b[i]=sc.nextInt();
           }
           for(int i=0;i<m;i++)
           {
               c[i]=sc.nextInt();
           }
           int answer[]=new int[m];
           deploysome obj=new deploysome();
           int ans=obj.solve(n,m,a,b,c,answer);
           if(ans==1)
           {
              System.out.println("YES");
              for(int i=0;i<m;i++)
                  System.out.print(answer[i]+" ");
              System.out.println();
           }
           else
           {
               System.out.println("NO");
           }
           
           
        }
  }
}
class deploysome
{
    public int solve(int n,int m,int a[],int b[],int c[],int answer)
    {
        int mis=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        HashMap<Integer,Integer>all=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(a[i]!=b[i])
            {
                 mis++;
                 h.put(b[i],h.getOrDefault(b[i],0)+1);
            }
            all.put(b[i],all.getOrDefault(b[i],0)+1);
        }
        if(mis>m)
            return -1;
        HashMap<Integer,Integer> rem=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            if(h.containsKey(c[i]) && h.get(c[i])>0)
            {
                h.put(c[i],h.get(c[i])-1);
            }
            else
            {
                rem.put(b[i],rem.getOrDefault(c[i],0)+1);
            }
        }
        Integer zero = new Integer(0);
        for (Integer i : h.values()) {
            if (!zero.equals(i)) {
                return -1;
            }
        }
        int some=0;
        int big=0;
        for (Integer i : rem.keySet()) {
            if (all.containsKey(i)) {
                if(rem.get(i)%2!=0)
                  some++;
            }
            else
            {
                big+=rem.get(i);
            }
        }
        if()
        
    }
    
}
