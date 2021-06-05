https://www.codechef.com/SPYB21B/problems/GOTHAM/

import java.util.*;
import java.lang.*;
import java.io.*;

class MyClass{
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
	class node
	{
	    int v;
	    int in;
	    node(int x,int y)
	    {
	        in=x;
	        v=y;
	    }
	}
    public static void main(String[] args) {
		 MyClass obj=new MyClass();
		 obj.helper();
	}
	
	public void helper()
	{
	    FastReader sc=new FastReader();
			int n=sc.nextInt();
			TreeMap<Integer,Integer> a=new TreeMap<>();
			for(int i =1;i <=n;i++)
			{
				int x;
				x=sc.nextInt();
				a.put(i,x);
			}
	        int q=sc.nextInt();
			while(q!=0)
			{
			    long ans=0;
			    int x=sc.nextInt();
			    int k=sc.nextInt();
			    Integer curr=x;
			    while(k!=0)
			    {
			        Integer temp=a.get(curr);
			        if(temp==null)
    			      curr=a.higherKey(x);
    			    if(curr==null)
    			    {
    			        break;
    			    }
			         int val=a.get(curr);
			         if(val<=k)
			         {
			             ans+=(long)(curr-x)*val;
			             k-=val;
			             a.remove(curr);
			         }
			         else
			            {
			                ans+=(long)(curr-x)*k;
			                a.put(curr,val-k);
			                k=0;
			            }
			        curr++;
			    }
			    q--;
			    System.out.println(ans);
			}
	}
}
