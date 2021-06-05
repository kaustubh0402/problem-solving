https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
//problem no : 1769

/*
Explanation:
Brute force :O(n^2) accepted
We will traverse complete array for each and every element let say i
if we found 1 at j i.e we have move this 1 at j to i
i.e. we have shift this absolute (j-i) 
*/

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(boxes.charAt(j)=='1' && i!=j)
                    count+=Math.abs(j-i);
            }
            ans[i]=count;
        }
        return ans;
    }
}
/*
Optimal:
what we have observe that one ball from a box to an adjacent box.
i.e. ball can be move to position from left as well as from right
n is length of string
here pos is position or 0 based indexing
Think when we have only one '1' in string i.e. "001000'
consider from left to right:
   consider psoition 2 (0 Indexed positioning) 
      Now onwards for pos 3=  1 operation
	              for pos 4=  2 operation
				  for pos 5=  3 operation
One thing we have noticed that current=previous+1

Similar thing will be done for right to left


Now what will happen if we found two '1' in string i.e. "00100100"
consider from left to right:
   consider psoition 2 (0 Indexed positioning) 
      Now onwards for pos 3=  1 operation
	              for pos 4=  2 operation
				  for pos 5=  3 operation
   Now we get '1' at position 5 so from 6 onwards we have to add opeartion for '1' at 5 psotion alse
                  for pos 6=  4 + 1 = 5 operation
				  for pos 7=  5 + 2 = 7 operation

Here we have noticed at as soon as we get new '1' we have to consider for new '1' also
now formula will be  current = previous + how many times 1 appear before

Similar thing will be done for right to left

here I have stored count of one from left to right in rcount and previous value in right
count of one from right to left in lcount and previous value in left
   
*/
class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        int right=0;
        int rcount=0;
        int left=0;
        int lcount=0;
        for(int i=0;i<n;i++)
        {
		    //from left to right
            ans[i]+=(right+rcount); // current=previous+nunber of '1' 
            right+=rcount; //Update previous value;
            //Increase count if we found '1'
			if(boxes.charAt(i)=='1')
                rcount++;
            
			//from right to left
			ans[n-1-i]+=(lcount+left);
            left+=lcount;
            if(boxes.charAt(n-1-i)=='1')
                lcount++;
        }
        return ans;
    }
}