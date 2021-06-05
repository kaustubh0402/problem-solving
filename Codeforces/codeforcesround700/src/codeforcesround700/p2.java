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
                int hatt=sc.nextInt();
                int hdef=sc.nextInt();
                int n=sc.nextInt();
                long a[]=new long[n];
                long b[]=new long[n];
                for(int i=0;i<n;i++)
                {
                    a[i]=sc.nextLong();
                }
                for(int i=0;i<n;i++)
                {
                    b[i]=sc.nextLong();
                }
                deployk obj=new deployk();
                boolean ans=obj.solve(hatt,hdef,n,a,b);
                if(ans==true)
                System.out.println("YES");
                else
                    System.out.println("NO");
           }
  }
}

 
class deployk 
{
    public class monster implements Comparable
    {
        long at;
        long def;
        public monster(long a,long d)
        {
            at=a;
            def=d;
        }
        public int compareTo(Object m) {
                return Long.compare(this.at,((monster)m).at);
    }
    }
    public boolean solve(int hatt,int hdef,int n,long a[],long b[])
    {
        monster arr[]=new monster[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new monster(a[i],b[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++)
        {
            int mul=(int)Math.ceil((double)arr[i].def/hatt);
            if(hdef<mul*arr[i].at)
              return false;
            hdef-=mul*arr[i].at;
        }
        int cnt=(int)Math.ceil((double)arr[n-1].def/hatt);
        
        while(cnt>0 && hdef>0)
        {
            hdef-=arr[n-1].at;
            cnt--;
        }
        if(hdef>0 || (cnt==0))
            return true;
        return false;
        
    }
}



