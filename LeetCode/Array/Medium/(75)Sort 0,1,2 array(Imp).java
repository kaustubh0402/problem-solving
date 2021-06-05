https://leetcode.com/problems/sort-colors/
//problem no: 75

//Interview solution 
class Solution {
    public void sortColors(int[] nums) {
        int one =0;
        int zero=0;
        int two=nums.length-1;
        while(one<=two)
        {
            if(nums[one]==2)
            {
                nums[one]=nums[two];
                nums[two]=2;
                two--;
            }
            else if(nums[one]==0)
            {
                nums[one]=nums[zero];
                nums[zero]=0;
                zero++;
                one++;
            }
            else
              one++;
        }
    }
}


//Not one pass solution easy one
class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                zero++;
            else if(nums[i]==1)
                one++;
            else
                two++;
        }
        for(int i=0;i<zero;i++)
            nums[i]=0;
        for(int i=zero;i<zero+one;i++)
            nums[i]=1;
        for(int i=zero+one;i<nums.length;i++)
            nums[i]=2;
    }
}