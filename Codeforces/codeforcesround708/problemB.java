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
			int m=sc.nextInt();
			ArrayList<Integer> a=new ArrayList<>();
			for(int i =0 ;i <n;i++)
			{
				int x;
				x=sc.nextInt();
				a.add(x%m);
			} 
			deploytemp obj=new deploytemp();
			int ans=obj.solve(a,n,m);
			System.out.println(ans);
		 }
	}
}
  
class deploytemp
{
   public int solve(ArrayList<Integer> a,int n,int m)
    {
        int arr[]=new int[m];
        for(int i=0;i<n;i++)
          arr[a.get(i)]++;
        int ans=0;
        if(arr[0]!=0)
          ans++;
        int l=1;
        int r=m-1;
        while(l<=r)
        {
            int common=Math.min(arr[l],arr[r]);
            if(common>0)
              ans+=1;
            int mx=Math.max(arr[l],arr[r]);
            if(mx!=0 && mx!=common && common!=0)
              mx--;
            ans+=mx-common;
            l++;
            r--;
        }
        return ans;
    }
}
