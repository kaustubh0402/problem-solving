https://practice.geeksforgeeks.org/problems/closest-strings0611/1/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            ArrayList<String> arr = new ArrayList<String>();
            String input[] = read.readLine().split(" ");
            
            for(int i = 0; i < n; i++){
                arr.add(input[i]);
            }
            String word1 = read.readLine();
            String word2 = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(arr,word1,word2));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int count1=Integer.MAX_VALUE,count2=Integer.MAX_VALUE,ans=Integer.MAX_VALUE,index=0;
        for(String it:s)
        {
            if(word1.equals(it))
            {
                ans=Math.min(ans,Math.abs(index-count2));
                count1=index;
            }
            if(word2.equals(it))
            {
                ans=Math.min(ans,Math.abs(index-count1));
                count2=index;
            }
            index++;
        }
        return ans;
    }
};