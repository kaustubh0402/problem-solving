https://leetcode.com/problems/next-greater-element-iii/
//problem no : 556

/*
Similar to find next permutation
Only difeeence that we should return -1 if no greater elemnt present unlike permutatio
problem no : 31 (next permutation)
*/

class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> input=new ArrayList<>();
        while(n!=0)
        {
            input.add(n%10);
            n=n/10;
        }
        Collections.reverse(input);
        int ans=nextPermutation(input.size(),input);
        if(ans<0)
            return -1;
        return ans;
    }
    
    int nextPermutation(int N, ArrayList<Integer> arr){
        int back=-1;
        for(int i=N-2;i>=0;i--)
        {
            if(arr.get(i)<arr.get(i+1))
            {
                back=i;
                break;
            }
        }
        if(back==-1)
            return -1;
        int swap=N-1;
        for(int i=N-1;i>back;i--)
        {
            if(arr.get(i)>arr.get(back))
            {
                swap=i;
                break;
            }
        }
        int temp=arr.set(swap,arr.get(back));
        arr.set(back,temp);
        
        for(int i=0;i<(N-back-1)/2;i++)
        {
            int t=arr.set(i+back+1,arr.get(N-1-i));
            arr.set(N-1-i,t);
        }
        int ans=0;
        int mul=1;
        for(int i=arr.size()-1;i>=0;i--)
        {
            if((long)ans+(long)mul*arr.get(i)>Integer.MAX_VALUE)
                return -1;
            ans+=(mul*arr.get(i));
            mul=mul*10;
        }
        return ans;
    }
}