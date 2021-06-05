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
			char a[][]=new char[n][n];
			for(int i =0 ;i <n;i++)
			{
				String x;
				x=sc.next();
				for(int j=0;j<n;j++)
				{
				    a[i][j]=x.charAt(j);
				}
			} 
			deploytemp obj=new deploytemp();
			obj.solve(a,n);
		 }
	}
}
  
class deploytemp
{
   public void solve(char a[][],int n)
    {
        int pt1x=-1;
        int pt1y=-1;
        int pt2x=-1;
        int pt2y=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]=='*')
                {
                    if(pt1x!=-1)
                    {
                        pt2x=i;
                        pt2y=j;
                    }
                    else
                    {
                        pt1x=i;
                        pt1y=j;
                    }
                }
            }
        }
        
        int m1x=-1;
        int m1y=-1;
        int m2y=-1;
        int m2x=-1;
        
        int diffx=Math.abs(pt1x-pt2x);
        int diffy=Math.abs(pt1y-pt2y);
        
        if(diffx!=0 && diffy!=0)
        {
            m1x=pt2x;
            m2x=pt1x;
            m1y=pt1y;
            m2y=pt2y;
        }
        else if(diffx==0)
        {
            if(pt1x!=n-1)
            {
                m1x=pt1x+1;
                m2x=pt2x+1;
            }
            else
            {
                m1x=pt1x-1;
                m2x=pt2x-1;
            }
            m1y=pt1y;
            m2y=pt2y;
        }
        else if(diffy==0)
        {
            if(pt1y!=n-1)
            {
                m1y=pt1y+1;
                m2y=pt2y+1;
            }
            else
            {
                m1y=pt1y-1;
                m2y=pt2y-1;
            }
            m1x=pt1x;
            m2x=pt2x;
        }
        
        a[m1x][m1y]='*';
        a[m2x][m2y]='*';
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
