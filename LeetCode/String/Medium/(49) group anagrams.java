https://leetcode.com/problems/group-anagrams/
//Problem no : 49


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList();
        HashMap<String,List> h=new HashMap<>();
        for(String s:strs)
        {
            char c[]=s.toCharArray();
            Arrays.sort(c);
            String modify=String.valueOf(c);
            if(h.containsKey(modify))
                h.get(modify).add(s);
            else
                h.put(modify,new ArrayList<>(Arrays.asList(s)));
        }
        return new ArrayList(h.values());
    }
}

//efficient solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

//gfg efficient solution
class Solution {
    public List<List<String>> Anagrams(String[] s) {
        HashMap<String,List> h=new HashMap<>();
        int n=s.length;
        for(int i=0;i<n;i++)
        {
            int freq[]=new int[26];
            for(int j=0;j<s[i].length();j++)
              freq[s[i].charAt(j)-'a']++;
            StringBuilder key=new StringBuilder("");
            for(int j=0;j<26;j++)
              key.append(freq[j]+"#");
            if(!h.containsKey(key.toString()))
              h.put(key.toString(),new ArrayList<>());
            h.get(key.toString()).add(s[i]);
        }
        return new ArrayList(h.values());
    }
}
