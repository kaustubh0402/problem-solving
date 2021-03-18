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
			ArrayList<Integer> a=new ArrayList<>();
			HashSet<Integer> h=new HashSet<>();
			ArrayList<Integer> arr=new ArrayList<>();
			for(int i =0 ;i <n;i++)
			{
				int x;
				x=sc.nextInt();
				if(h.contains(x))
				  arr.add(x);
				else
				{
				    a.add(x);
				    h.add(x);
				}
			}
			Collections.sort(a);
			for(int i=0;i<a.size();i++)
			  System.out.print(a.get(i)+" ");
			for(int i=0;i<arr.size();i++)
			  System.out.print(arr.get(i)+" ");
			System.out.println();
			
		 }
	}
}
 
