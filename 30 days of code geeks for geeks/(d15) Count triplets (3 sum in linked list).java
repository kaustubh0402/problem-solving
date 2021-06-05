
/*
Given a sorted linked list of distinct nodes 
(no two nodes have the same data) and an integer X.
 Count distinct triplets in the list that sum up to given integer X.

Example 1:

Input: LinkedList: 1->2->4->5->6->8->9, X = 17
Output: 2
Explanation: Distinct triplets are (2, 6, 9) 
and (4, 5, 8) which have sum equal to X i.e 17.
*/


class Solve
{
    static int countTriplets(Node head, int x) 
    {
        int ans=0;
        Node curr=head;
        ArrayList<Integer> a=new ArrayList<>();
        while(curr!=null)
        {
            a.add(curr.data);
            curr=curr.next;
        }
        int n=a.size();
        for(int i=0;i<n-1;i++)
        {
            int start=i+1;
            int end=n-1;
            int required=x-a.get(i);
            while(start<end)
            {
                int first=a.get(start);
                int second=a.get(end);
                if(required==first+second)
                {
                    ans++;
                    start++;
                    end--;
                }
                else if(required>first+second)
                  end--;
                else
                  start++;
            }
        }
        return ans;
    } 
}