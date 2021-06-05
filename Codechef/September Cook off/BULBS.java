/* package codechef; // don't place package name! */
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BULBS
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
		int t=sc.nextInt();
     	while(t-- >0)
     	{
		  int n=sc.nextInt();
		  int k=sc.nextInt();
		  String s=sc.next();
          deployB obj=new deployB();
          int cuts=obj.solve(n,k,s);
          System.out.println(cuts);
 		}
      }
	}
}
class deployB
{
    public int solve(int n,int k,String s)
    {
        ArrayList<Integer> diff=new ArrayList<Integer>();
        int prev=-1;
        int i;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                diff.add(i-prev-1);
                prev=i;
            }
        }
        diff.add(i-prev-1);
        int l=diff.size();
        if(k>=2*(l-1))
        return 0;
        int flag=0;
        int left=diff.get(0);
        int right=diff.get(l-1);
        int addn=left+right;
        int forodd=Math.max(left,right);
        int forev=Math.min(left,right);
        Collections.sort(diff,Collections.reverseOrder());
        for(int v=0;v<k/2;v++)
        {
            if((k & 1)==0)
            {
            if(diff.get(0)<=addn && flag==0)
            {
                diff.remove(new Integer(left));
                diff.remove(new Integer(right));
                flag=1;
                continue;
            }
            }
            else
            {
            if(diff.get(0)==forodd && flag==0)
            {
                diff.remove(new Integer(forodd));
                flag=1;
            }
            
            }
            diff.remove(0);
        }
        int answer=0;
        for(int j=0;j<diff.size();j++)
           answer+=diff.get(j);
        if((k & 1)!=0 && flag==0)
           answer=answer-forodd;
        return answer;
    }
    
}
