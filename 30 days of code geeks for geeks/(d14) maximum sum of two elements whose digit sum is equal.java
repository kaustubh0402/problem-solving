https://www.geeksforgeeks.org/maximum-sum-of-two-elements-whose-digit-sum-is-equal/

/*
Approach:
1) First suppose if we have sum of digits of each number
2) Then our task is to find same number from above with maximum sum
3) We will use hashMap (key,pair)==(sum of digit , number)
we will store sum of digit as key and corresponding number as value
4) Iterate on array:
	a) If element not found in hashmap..add to hashmap
	b)if element already found :
		i) Then check if sum of num +curr is greater than previous sum
		ii) Suppose current number is gretaer than hashmap number
		then update number with current number
*/

class Solution { 
	static int RulingPair(int arr[], int no) { 
        HashMap<Integer,Integer> h=new HashMap<>();
        int sum=-1;
        for(int n : arr)
        {
            int dig=0;
            int num=n;
            while(n!=0)
            {
                dig+=(n%10);
                n=n/10;
            }
            if(h.containsKey(dig))
            {
                int curr=h.get(dig);
                sum=Math.max(sum,curr+num);
                if(num>curr)
                  h.put(dig,num);
            }
            else
                h.put(dig,num);
        }
        return sum;
	}    
}