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
           int n=sc.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++)
           {
               a[i]=sc.nextInt();
           }
           deploysome obj=new deploysome();
           int ans=obj.solve(n,a);
           System.out.println(ans);
  }
}
class deploysome
{
    public int solve(int n,int a[])
    {
        ArrayList<Integer> one=new ArrayList<>();
        ArrayList<Integer> two=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int curr=a[i];
            if(one.size()==0)
                one.add(curr);
            else if(one.size()!=0 && one.get(one.size()-1)!=curr)
                one.add(curr);
            else if(two.size()==0)
                two.add(curr);
            else if(two.size()!=0 && two.get(two.size()-1)!=curr)
                two.add(curr);
        }
        return one.size()+two.size();
    }
    
}
