//https://leetcode.com/problems/maximum-number-of-balloons/submissions/
//Problem no: 1189

class Solution
{
    public int maxNumberOfBalloons(String text) {
            int[] cnt = new int[26], cntBaloon = new int[26];
            for (int i = 0; i < text.length(); ++i)
                ++cnt[text.charAt(i) - 'a'];
            int min = text.length();
            for (char c : "balloon".toCharArray())
                ++cntBaloon[c - 'a'];
            for (char c : "balloon".toCharArray())
                min = Math.min(min, cnt[c - 'a'] / cntBaloon[c - 'a']);
            return min;
        }
}

//Solution 2
/*
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character, Integer> map=new HashMap<Character,Integer>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(int i=0;i<text.length();i++)
        {
            if(map.containsKey(text.charAt(i)))
            {
                map.put(text.charAt(i),map.get(text.charAt(i))+1);
            }
        }
        int dbl=Math.min(map.get('l')/2,map.get('o')/2);
        int count=Integer.MAX_VALUE;
        for(Integer ans:map.values())
        {
            count=Math.min(count,ans);
        }
        return Math.min(count,dbl);
    }
}
*/