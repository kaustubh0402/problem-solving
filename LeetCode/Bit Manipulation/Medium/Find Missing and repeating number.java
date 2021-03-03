https://leetcode.com/problems/set-mismatch/
//problem no: 645

/*
Explanation:
Other than following methods:
1.Brute Force (comapare each index and check duplicate) O(n^2)
2.Sorting ( Sort array and check which consecutive index are same) O(nlogn)
3.Using HashMap O(n) / Or frequency array
4.Using XOR ( Same as sum where we want to find 2 odd times repeating number)
   (By XORING all array and natural number, checking set bit from right) O(n)
*/


/*
Explanation:
Using Following Equations:
x^2 -y^2= (x+y)(x-y)
Consider x as repeatiting number and y as missing number
we know , sum of natural number till n let say val=(n*(n+1)/2)
and sum of square of natural number till n let say sval=(n*(n+1)*(2*n+1)/6)
consider sum as sum of all elements in array 
Here sum will be val(sum of natural) +x (Extra repeating number) -y(missing number)
i.e. sum=val+(x-y)
and ssum as square of all elements in array
similarly ssum=sval + x^2 -y^2;
so, ssum=sval+(x+y)(x-y);
     ssum=sval +(x+y)(sum-val)
		 in above we already find ssum,sval,sum,val
now we can calculate x+y from above equations
no we have x+y and x-y so we can calculate x and y i.e our answer
converting above logic in program:
*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        long sum=0,ssum=0;
        long n=nums.length;
        for(int i=0;i<(int)n;i++)
        {
            sum+=nums[i];
            ssum+=(nums[i]*nums[i]);
        }
        long val=sum-(n*(n+1)/2);
        long sval=ssum-(n*(n+1)*(2*n+1)/6);
        long sadd=sval/val;
        int ans[]=new int[2];
        ans[0]=(int)((val+sadd)/2);
        ans[1]=(int)(sadd-ans[0]);
        return ans;
    }
}


//check else if condition if you not understand

class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int temp=Math.abs(nums[i]);
            ans[1]=ans[1]^(i+1)^(temp);
            if(nums[temp-1]<0)
                ans[0]=temp;
            else if(nums[temp-1]>0)
                nums[temp-1]=-nums[temp-1];
        }
        ans[1]=ans[1]^ans[0];
        return ans;
    }
}


class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor=0;
        int n=nums.length;
        int ans[]=new int[2];
        for(int i=0;i<n;i++)
            xor=xor^nums[i]^(i+1);
        int rightmostbit=(xor)& ~(xor-1);
        int one=0;
        int two=0;
        for(int i=0;i<n;i++)
        {
            if((rightmostbit &nums[i])!=0)
                one^=nums[i];
            else
                two^=nums[i];
            if(((i+1)&rightmostbit)!=0)
                one^=(i+1);
            else
                two^=(i+1);
        }
        int count=0;
        for(int i=0;i<n;i++)
            if(one==nums[i])
                count++;
        if(count==2)
        {
            ans[0]=one;
            ans[1]=two;
        }
        else
        {
            ans[0]=two;
            ans[1]=one;
        }
        return ans;
    }
}