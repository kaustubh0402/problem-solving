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
                int x=sc.nextInt();
                int y=sc.nextInt();
                deploy obj=new deploy();
                int ans=obj.solve(x,y);
                System.out.println(ans);
           }
    }
}

class deploy
{
    public int solve(int x,int y)
    {
        int cnt=0;
        int lg=0;
        int ans=Integer.MAX_VALUE;
        if(x==y)
            return 2;
        if(x<y)
            return 1;
        if(y==1)
        {
            cnt++;
            y++;
        }
        for(int i=y;i<=x;i++)
        {
            lg=(int)(Math.log(x)/Math.log(i));
            ans=Math.min(lg+cnt+1,ans);
            cnt++;
            if(lg+cnt>ans)
                break;
            
        }
        return ans;
    }
    
    
}


