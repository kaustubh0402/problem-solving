https://practice.geeksforgeeks.org/problems/delete-keys-in-a-linked-list/1


class GfG
{
    public static Node deleteAllOccurances(Node head, int x)
    {
        Node curr=new Node(0);
        curr.next=head;
        Node ans=curr;
        while(curr.next!=null)
        {
            if(curr.next.data==x)
                curr.next=curr.next.next;
            else
                curr=curr.next;
        }
        return ans.next;
    }
}