import java.util.*;
import java.lang.*;
import java.io.*;

public class chef{
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
			int a[]=new int[n];
			for(int i =0 ;i <n;i++)
			{
				int x;
				x=sc.nextInt();
				a[i]=x;
			} 
			deploytemp obj=new deploytemp();
			int ans=obj.solve(a,n);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public int solve(int a[],int n)
    {
        int ans=0;
        int rem[]=new int[3];
        for(int i=0;i<n;i++)
        {
            if(a[i]%3==0)
              rem[0]++;
            else if(a[i]%3==1)
              rem[1]++;
            else
              rem[2]++;
        }
        int mid=n/3;
        if(rem[0]>mid)
        {
            rem[1]+=(rem[0]-mid);
            ans+=(rem[0]-mid);
            rem[0]=mid;
        }
        if(rem[1]>mid)
        {
            rem[2]+=(rem[1]-mid);
            ans+=(rem[1]-mid);
            rem[1]=mid;
        }
        if(rem[2]>mid)
        {
            rem[0]+=(rem[2]-mid);
            ans+=(rem[2]-mid);
            rem[2]=mid;
        }
        if(rem[0]>mid)
        {
            rem[1]+=(rem[0]-mid);
            ans+=(rem[0]-mid);
            rem[0]=mid;
        }
        if(rem[1]>mid)
        {
            rem[2]+=(rem[1]-mid);
            ans+=(rem[1]-mid);
            rem[1]=mid;
        }
        if(rem[2]>mid)
        {
            rem[0]+=(rem[2]-mid);
            ans+=(rem[2]-mid);
            rem[2]=mid;
        }
        return ans;
    }
}
/*
4
6
0 2 5 5 4 8
6
2 0 2 1 0 0
9
7 1 3 4 2 10 3 9 6
6
0 1 2 3 4 5
*/
