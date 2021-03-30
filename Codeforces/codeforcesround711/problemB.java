import java.util.*;
import java.lang.*;
import java.io.*;

public class problem{
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
			int w=sc.nextInt();
			TreeMap<Integer,Integer> tm=new TreeMap<>();
			for(int i=0;i<n;i++)
			{
			    int x=sc.nextInt();
			    tm.put(x,tm.getOrDefault(x,0)+1);
			}
			deploytemp obj=new deploytemp();
			int ans=obj.solve(n,w,tm);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public int solve(int n,int w, TreeMap<Integer,Integer> tm)
    {
        int wt=w;
        int ans=1;
        while(tm.size()!=0)
        {
            Integer key=tm.lowerKey(wt+1);
            if(key==null)
            {
                wt=w;
                ans++;
            }
            else
            {
                wt=wt-key;
                tm.put(key,tm.get(key)-1);
                if(tm.get(key)==0)
                  tm.remove(key);
            }
        }
        return ans;
    }
}
