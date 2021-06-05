//https://leetcode.com/problems/distribute-candies-to-people/
//problem no: 1103

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int arr[]=new int[num_people];
        int add=0;
        int i=0;
        while(candies>=0)
        {
            arr[i]+=++add;
            i++;
            if(i==num_people)
                i=0;
            candies=candies-add;
        }
        if(i==0)
            i=num_people;
        arr[i-1]+=candies;
        return arr;
    }
}