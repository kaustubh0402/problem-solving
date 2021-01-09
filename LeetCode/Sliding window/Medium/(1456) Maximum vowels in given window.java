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