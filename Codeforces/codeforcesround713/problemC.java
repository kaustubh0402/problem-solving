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
			int m=sc.nextInt();
			String s=sc.next();
			int a=n+m;
			deploytemp obj=new deploytemp();
			obj.solve(s,a,n,m);
		 }
	}
}
  
class deploytemp
{
   public void solve(String sr,int n,int a,int br)
    {
        StringBuilder s=new StringBuilder(sr);
        int arr[]=new int[2];
        arr[0]=a;
        arr[1]=br;
        int later=0;
        if((n&1)==0)
        {
            if((a&1)==1 && (br&1)==1)
            {
                System.out.println(-1);
                return;
            }
        }
        for(int i=0;i<n/2;i++)
        {
            char c=sr.charAt(i);
            char b=sr.charAt(n-i-1);
            if(c=='?' && b=='?')
            {
                later+=2;
                continue;
            }
            if(c=='?')
            {
                if(arr[b-48]>=2)
                {
                    arr[b-48]-=2;
                    s.setCharAt(i,b);
                }
                else
                {
                    System.out.println(-1);
                    return;
                }
            }
            else if(b=='?')
            {
                if(arr[c-48]>=2)
                {
                    arr[c-48]-=2;
                    s.setCharAt(n-i-1,c);
                }
                else
                {
                    System.out.println(-1);
                    return;
                }
            }
            else
            {
                if(b!=c)
                {
                    System.out.println(-1);
                    return;
                }
                else
                {
                    if(arr[b-48]<2)
                    {
                        System.out.println(-1);
                        return;
                    }
                    arr[b-48]-=2;
                }
            }
        }
        if((n&1)==1)
        {
            char find=sr.charAt(n/2);
            if(find=='?')
            {
                char add=((arr[0]&1)==1)?'0':'1';
                s.setCharAt(n/2,add);
                if(arr[add-48]<=0)
                {
                    System.out.println(-1);
                    return;
                }
                arr[add-48]--;
            }
            else
            {
                if(arr[find-48]<=0)
                {
                    System.out.println(-1);
                    return;
                }
                arr[find-48]--;
            }
        }
        
        for(int i=0;i<n/2;i++)
        {
            if(s.charAt(i)=='?')
            {
                if(arr[0]>=2)
                {
                    s.setCharAt(i,'0');
                    s.setCharAt(n-i-1,'0');
                    arr[0]-=2;
                }
                else if(arr[1]>=2)
                {
                    s.setCharAt(i,'1');
                    s.setCharAt(n-i-1,'1');
                    arr[1]-=2;
                }
                else
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(s);
    }
}
