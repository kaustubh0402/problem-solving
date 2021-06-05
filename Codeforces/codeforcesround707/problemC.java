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
			int n=sc.nextInt();
			int a[]=new int[n];
			ArrayList<Integer> b=new ArrayList<Integer>();
			for(int i =0 ;i <n;i++)
			{
				a[i]=sc.nextInt();
				b.add(a[i]);
			} 
			deploytemp obj=new deploytemp();
			obj.solve(a,n,b);
	}
}
  
class deploytemp
{
   public void solve(int a[],int n,ArrayList<Integer> b)
    {
        Collections.sort(b);
        int last=5000000;
        int m1=-1;
        int m2=-1;
        int m3=-1;
        int m4=-1;
        for(int i=2;i<=last;i++)
        {
            int target=i;
            int start = 0, end = n-1;
            while (start<end) {
                int mid = (end - start) / 2 + start;
                int sum =b.get(start) + b.get(end);
                if (sum == target) {
                    m1=start;
                    m2=end;
                    break;
                }
                else if (sum < target) {
                    start=(b.get(mid)+b.get(end)<target) ? mid : start + 1;
                }
                else{
                    end=(b.get(mid)+b.get(start)>target)?mid:end-1;
                }
            }
            if(m1==-1)
              continue;
            
            start = m1;
            end = m2;
            while (start<end) {
                int mid = (end - start) / 2 + start;
                int sum =b.get(start) + b.get(end);
                if (sum == i && m1!=start && m2!=end && m1!=end && m2!=start)
                {
                    m3=start;
                    m4=end;
                    break;
                }
                else if(sum==i && (m1==start || m2==start))
                    start++;
                else if(sum==i)
                      end--;
                else if (sum < target) {
                    start=(b.get(mid)+b.get(end)<target) ? mid : start + 1;
                }
                else{
                    end=(b.get(mid)+b.get(start)>target)?mid:end-1;
                }
            }
            if(m3!=-1)
            {
                System.out.println("YES");
                int one=b.get(m1);
                int two=b.get(m2);
                int three=b.get(m3);
                int four=b.get(m4);
                for(int j=0;j<n;j++)
                {
                    if(a[j]==one)
                      System.out.print(j+1+" ");
                    else if(a[j]==two)
                      System.out.print(j+1+" ");
                    else if(a[j]==three)
                      System.out.print(j+1+" ");
                    else if(a[j]==four)
                      System.out.print(j+1+" ");
                }
                System.out.println();
                return ;
            }
        }
         System.out.println("NO");
        
    }
}
