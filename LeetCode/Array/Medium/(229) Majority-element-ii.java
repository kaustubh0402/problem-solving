https://leetcode.com/problems/majority-element-ii/
//Problem no : 229


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
		//Take two num (Max there will be two numbers (not necessary to two)
        Integer num1=nums[0];
        Integer num2=nums[0];
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==num1)
                cnt1++;
            else if(nums[i]==num2)
                cnt2++;
            else if(cnt1==0)
            {
                num1=nums[i];
                cnt1=1;
            }
            else if(cnt2==0)
            {
                num2=nums[i];
                cnt2=1;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
		//Chcek whether found num exist greater than n/3 
        for(int i=0;i<n;i++)
        {
            if(nums[i]==num1)
                cnt1++;
            else if(nums[i]==num2)
                cnt2++;
        }
        if(cnt1>n/3)
            ans.add(num1);
        if(cnt2>n/3)
            ans.add(num2);
        return ans;
    }
}