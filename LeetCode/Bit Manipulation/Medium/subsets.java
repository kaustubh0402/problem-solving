https://leetcode.com/problems/subsets/
//problem no :78

/*
Explanation:
refer gfg notes(Bit manipulation)

*/
//Bitwise solutiion (2^n * n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList();
        int len=nums.length;
        int powlen=(int)Math.pow(2,len);
        List<Integer> temp;
        for(int i=0;i<powlen;i++)
        {
            temp=new ArrayList<Integer>();
            for(int j=0;j<len;j++)
            {
                if(((i>>j)&1)==1)
                    temp.add(nums[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}


/*
Using Recursion:
We can either take elemnt or not
If we take elemnt then we have to remove it after recursion call
*/
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> temp=new ArrayList<>();
        helper(nums,temp,0);
        return ans;
    }
    
    void helper(int nums[],ArrayList<Integer> a,int i)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<>(a));
            return;
        }
        a.add(nums[i]);
        helper(nums,a,i+1);
        a.remove(a.size()-1);
        helper(nums,a,i+1);
    }
}

//Recursion solution :2
vector<vector<int> >ans;
void find(vector<int>&arr,int index, vector<int>temp)
{
     ans.push_back(temp);
     if(index>=arr.size())
        return ;

     for(int i=index;i<arr.size();i++)
     {
          temp.push_back(arr[i]);
          find(arr,i+1,temp);
          temp.pop_back();
		}
}
