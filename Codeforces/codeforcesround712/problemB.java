import java.util.*;
import java.lang.*;
import java.io.*;

public class MyClass{
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
			String a=sc.next();
			String b=sc.next();
			deploytemp obj=new deploytemp();
			boolean ans=obj.solve(a,b,n);
			if(ans==true)
			  System.out.println("YES");
			else
			  System.out.println("NO");
		 }
	}
}
  
class deploytemp
{
   public boolean solve(String a,String b,int n)
    {
        int count1=0;
        int count2=0;
        int arr[]=new int[n];
        int count[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(a.charAt(i)=='1')
              count1++;
            if(b.charAt(i)=='1')
              count2++;
            if(a.charAt(i)==b.charAt(i))
              arr[i]=1;
            if((i+1)==2*count1)
              count[i]=1;
        }
        if(count1!=count2)
          return false;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                if(count[i]!=1)
                  return false;
            }
        }
        return true;
    }
}
