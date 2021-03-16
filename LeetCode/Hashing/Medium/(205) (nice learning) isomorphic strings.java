https://leetcode.com/problems/isomorphic-strings/
//Problem no : 205

/*
Lets start with given:
1)characters in s can b replaced to get c
2)we have to map character from t to charater from s
3)No two characters may map to the same characte

From above we have conclude that we have to do 1:1 mapping
i.e exactly one char from t should be mappped with only one char from s

1) HashMap in java used for many :1 mapping 
conisder hashmap(key,value)
here key is unique we have to make value also unique
we can check containsvalue function but it will take O(n) time

So we will use hashset for value to do above task in O(1)
hashmap(key,value) ==> key is unique
hashset(value) ==> value is unique
Now both are unique hence 1:1 mapping can be achieved

//Not sure about following
we can use graph
and check indegree and outdegree of every elemnt 
if indegree or outdegree of graph is greater than 1 then 1:1 mapping no there
*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int n=s.length();
        HashMap<Character,Character> h=new HashMap<>();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            char one=s.charAt(i);
            char two=t.charAt(i);
            if(h.containsKey(two))
            {
                if(h.get(two)!=one)
                    return false;
            }
            else if(hs.contains(one))
                return false;
            h.put(two,one);
            hs.add(one);
        }
        return true;
    }
}

//Nice solution without using hahsmap

public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}

