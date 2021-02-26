https://leetcode.com/problems/check-array-formation-through-concatenation/
//Problem no : 1640

/*
Explnation
We have to check two condition
1) If element in pieces is present in array or not
2) found index of first element of each pieces in an array 
    and check whether all elements in pieces comes in array continuos or not 
3) Above point ensures that order in pieces should not be distorted
*/


class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++)
            h.put(arr[i],i);
        for(int i=0;i<pieces.length;i++)
        {
                if(!h.containsKey(pieces[i][0]))
                  return false;
                int index=h.get(pieces[i][0]);
                int j=0;
                for(j=0;j<pieces[i].length && index<arr.length;j++)
                {
                    if(!h.containsKey(pieces[i][j]))
                        return false;
                    if(arr[index++]!=pieces[i][j])
                        return false;
                }
                if(j!=pieces[i].length)
                    return false;
        }
        return true;
    }
}