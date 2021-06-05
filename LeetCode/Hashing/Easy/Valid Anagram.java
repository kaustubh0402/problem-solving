//https://leetcode.com/problems/valid-anagram/
//problem no 242
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> m=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
            m.put(t.charAt(i),m.getOrDefault(t.charAt(i),0)-1);
        }
        for(int temp:m.values())
        {
            if(temp!=0)
                return false;
        }
        return true;
    }
}
//Note : we can use Frequency array of lowercase char instead of hashmap but
//in case of unicode we have to use hashmap.