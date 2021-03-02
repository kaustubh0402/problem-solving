https://leetcode.com/problems/next-permutation/
//problem no : 31
https://practice.geeksforgeeks.org/problems/next-permutation5226/1#

/*
Approach:
As we know unit place has lower value than ten place and so on
so we have to start from right(from unit place)
and find first number which is smaller than previous right digit(we will change this number)
We will swap this number with just greater number and remaining elemnts sould be sorted
But as they are already in decresing order we just havr to reverse them
watch take u foeward video fro intution

Basically 3 steps:
1) find first smallest digit(number) in array which is smaller than its right digit
2) Swap this FIRST smaller number with number just greater than it from right aide of array
3) from next index of first smaller number sort ascending order   

*/

//gfg solution
class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        int back=-1;
        for(int i=N-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                back=i;
                break;
            }
        }
        int swap=N-1;
        for(int i=N-1;i>back && back!=-1;i--)
        {
            if(arr[i]>arr[back])
            {
                swap=i;
                int temp=arr[swap];
                arr[swap]=arr[back];
                arr[back]=temp;
                break;
            }
        }
        for(int i=0;i<(N-back-1)/2;i++)
        {
            int t=arr[i+back+1];
            arr[i+back+1]=arr[N-1-i];
            arr[N-1-i]=t;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int num:arr)
          ans.add(num);
        return ans;
    }
}


//Leetcode solution
class Solution {
    public void nextPermutation(int[] nums) {
        int i=0;
        int index=-1;
        int n=nums.length;
        while(i<n-1)
        {
            if(nums[i]<nums[i+1])
                index=i;
            i++;
        }
        int last=n-1;
        while(last>=index && index!=-1)
        {
            if(nums[last]>nums[index])
            {
                int temp=nums[last];
                nums[last]=nums[index];
                nums[index]=temp;
                break;
            }
            last--;
        }
        int j=n-1;
        i=index;
        i++;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
            i++;
        }
    }
}


