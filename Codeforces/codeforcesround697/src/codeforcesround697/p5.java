import java.util.*;
import java.lang.*;
import java.io.*;

public class p5 {
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
           while(t-->0)
           {
           int n=sc.nextInt();
           int k=sc.nextInt();
           TreeMap<Integer,Integer> tr=new TreeMap<>(Collections.reverseOrder());
           for(int i=0;i<n;i++)
           {
               int curr=sc.nextInt();
               if(!tr.containsKey(curr))
               {
                   tr.put(curr,1);
               }
               else
               {
                   tr.replace(curr,tr.get(curr)+1);
               }
           }
           deployp5 obj=new deployp5();
           int ans=obj.solve(n,k,tr);
           System.out.println(ans);
           }
  }
}
class deployp5
{
    int mod=1000000007;
    public int solve(int n,int k,TreeMap<Integer,Integer> t)
    {
        int ans=0;
        int temp=k;
        while(k>=0)
        {
            if(k==0)
            {
                ans++;
                return ans;
            }
            if(t.isEmpty())
                return -1;
            Integer val=t.firstKey();
            Integer frequency=t.get(val);
            t.remove(val);
            if(frequency<k)
            {
                k=k-frequency;
                continue;
            }
            k=frequency-k;
            return nCrModpDP(frequency,k,mod);
        }
        return -1;
    }
//    int nCr(int n, int r) 
//    { 
//        return fact(n) / (((fact(r) * fact(n - r)))%mod);  
//    } 
//
//    // Returns factorial of n 
//    int fact(int n) 
//    { 
//        int res = 1; 
//        for (int i = 2; i <= n; i++) 
//            res = ((res %mod)*(i%mod))%mod; 
//        return res; 
//    } 
    static int nCrModpDP(int n, int r, int p) 
{ 
    // The array C is going to store last row of 
    // pascal triangle at the end. And last entry 
    // of last row is nCr 
    int[] C=new int[r+1]; 
  
    C[0] = 1; // Top row of Pascal Triangle 
  
    // One by constructs remaining rows of Pascal 
    // Triangle from top to bottom 
    for (int i = 1; i <= n; i++) 
    { 
        // Fill entries of current row using previous 
        // row values 
        for (int j = Math.min(i, r); j > 0; j--) 
  
            // nCj = (n-1)Cj + (n-1)C(j-1); 
            C[j] = (C[j] + C[j-1])%p; 
    } 
    return C[r]; 
} 
  
// Lucas Theorem based function that returns nCr % p 
// This function works like decimal to binary conversion 
// recursive function. First we compute last digits of 
// n and r in base p, then recur for remaining digits 
static int nCrModpLucas(int n, int r, int p) 
{ 
// Base case 
if (r==0) 
    return 1; 
  
// Compute last digits of n and r in base p 
int ni = n%p; 
int ri = r%p; 
  
// Compute result for last digits computed above, and 
// for remaining digits. Multiply the two results and 
// compute the result of multiplication in modulo p. 
return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r 
        nCrModpDP(ni, ri, p)) % p; // Remaining digits 
}
}
