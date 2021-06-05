https://leetcode.com/problems/3sum/
//Problem  no : 15

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            int left=i+1;
            int right=n-1;
            int sum=-nums[i];
            while(left<right)
            {
                int twosum=nums[left]+nums[right];
                if(twosum==sum)
                {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                }
                else if(twosum<sum)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
            while(i<n-1 && nums[i]==nums[i+1])
                i++;
        }
        return ans;
    }
}