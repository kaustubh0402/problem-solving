https://leetcode.com/problems/bulls-and-cows/
//Problem no : 299


//We can solve using two loop simple implementation
//Below is One pass implementation
class Solution {
    public String getHint(String secret, String guess) {
        int freq[]=new int[10];
        int n=guess.length();
        int bulls=0;
        int cows=0;
        for(int i=0;i<n;i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
                bulls++;
            freq[secret.charAt(i)-48]++;
            freq[guess.charAt(i)-48]--;
        }
        int uncommon=0;
        for(int i=0;i<10;i++)
            uncommon+=(Math.abs(freq[i]));
        cows=(2*n-uncommon-2*bulls)/2;
        return new StringBuilder(bulls+"A"+cows+"B").toString();
    }
}