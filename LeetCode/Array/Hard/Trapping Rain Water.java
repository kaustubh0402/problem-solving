//https://leetcode.com/problems/trapping-rain-water/
//problem no: 42
/*Explanation:
  Maintain 2 arrays left and right
  Left array : It will store maximum value available at left side of i in array for every element at ith position in array
  Right array : It will store maximum value available at right side of i in array for every element at ith position in array
  so for every i (height in array):
    we will subtract height at i from ( min of (left at i ,right at i))
	add above to answer
  
  basically we are creating walls of height at left and right at every position so water can store in that wall for every i
  and selecting min wall 
  
  we can solve above problem using two point approach as well. with constant space.
*/
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0)
            return 0;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
            left[i]=Math.max(left[i-1],height[i]);
        }
        for(int j=n-2;j>=0;j--)
        {
            right[j]=Math.max(right[j+1],height[j]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
/*
My Two pointer solution gfg

import java.io.*;
import java.util.*;

class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Trap obj = new Trap();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends




class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
        
       int l=0;
       int r=n-1;
       int ans=0;
       int l_max=0,r_max=0;
       while(l<=r)
       {
           if(arr[l]<arr[r])
           {
             if(arr[l]>=l_max)
             {
                 l_max=arr[l];
             }
             else
             {
                 ans+=l_max-arr[l];
             }
             l++;
           }
           else
           {
               if(arr[r]>=r_max)
               {
                   r_max=arr[r];
               }
               else
               {
                   ans+=r_max-arr[r];
               }
               r--;
           }
            
       }
       return ans;
    } 
}

*/