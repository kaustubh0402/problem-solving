https://leetcode.com/problems/distribute-candies/
problem no : 575

class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet <Integer> h=new HashSet <Integer>();
        for(int num:candyType)
            h.add(num);
        int n=candyType.length;
        if(n/2<=h.size())
            return n/2;
        return h.size();
    }
}