https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
//Problem no : 1456


//bit faster than usual
class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int answer=0;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(i<k)
            {
                if(isvowel(curr))
                  cnt++;
            }
            else
            {
                char prev=s.charAt(i-k);
                if(isvowel(curr))
                {
                    cnt++;
                }
                if(isvowel(prev))
                    cnt--;
            }
            answer=Math.max(answer,cnt);
        }
        return answer;
    }
    
    public boolean isvowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return true;
        return false;
    }
}


//Only hashset use instead of funciton
class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        HashSet<Character> v=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int answer=0;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(i<k)
            {
                if(v.contains(curr))
                  cnt++;
            }
            else
            {
                char prev=s.charAt(i-k);
                if(v.contains(curr))
                {
                    cnt++;
                }
                if(v.contains(prev))
                    cnt--;
            }
            answer=Math.max(answer,cnt);
        }
        return answer;
    }
}

//Without space optimization
class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        HashSet<Integer> ans=new HashSet<>();
        HashSet<Character> v=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int answer=0;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(i<k && v.contains(curr))
            {
                cnt++;
                ans.add(i);
            }
            else
            {
                if(v.contains(curr))
                {
                    ans.add(i);
                    cnt++;
                }
                if(ans.contains(i-k))
                    cnt--;
            }
            answer=Math.max(answer,cnt);
        }
        return answer;
    }
}