https://leetcode.com/problems/valid-mountain-array/
//Problem no : 941

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3)
            return false;
        int increase=0;
        int decrease=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i-1]<arr[i])
            {
                if(decrease==1)
                    return false;
                if(increase==0)
                    increase=1;
            }
            else if(arr[i-1]>arr[i])
            {
                if(increase==0)
                    return false;
                if(decrease==0)
                    decrease=1;
            }
            else
                return false;
        }
        return (increase==1 && decrease==1);
    }
}


//clean code

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3)
            return false;
        int i=1;
        while(i<n && arr[i-1]<arr[i])
            i++;
        if(i==1 || i==n)
            return false;
        while(i<n && arr[i-1]>arr[i])
            i++;
        if(i==n)
            return true;
        return false;
    }
}