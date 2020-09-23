import java.util.*;
import java.lang.*;
import java.io.*;

class card {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     if(sc.hasNextInt()) 
      {
        int t=sc.nextInt();
     	while(t-- >0)
     	{
	   int my=sc.nextInt();
           int your=sc.nextInt();
          deploycard obj=new deploycard();
          obj.solve(my,your);
 	}
      }
        
  }
    
}
class deploycard
{
    public void solve(int my,int your)
    {
        int ans1,ans2;
        ans1=my/9;
        ans2=your/9;
        ans1=(my%9==0)?ans1:ans1+1;
        ans2=(your%9==0)?ans2:ans2+1;
        int final_answer=Math.min(ans1,ans2);
        if(ans1<ans2)
        System.out.println(0+" "+final_answer);
        else
        System.out.println(1+" "+final_answer);
    }
    
}
