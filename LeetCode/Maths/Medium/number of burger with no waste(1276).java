https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
//Problem no : 1276

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(tomatoSlices<2*cheeseSlices || tomatoSlices>4*cheeseSlices)
            return ans;
        int big=0,small=cheeseSlices,remain=tomatoSlices-2*cheeseSlices;
        if((remain&1)==1)
            return ans;
        big=remain>>1;
        small=small-big;
        ans.add(big);
        ans.add(small);
        return ans;
    }
}