https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

//Multiple methods are there
class Intersect
{
	int intersectPoint(Node head1, Node head2)
	{
         int len1=0;
         int len2=0;
         Node curr1=head1;
         Node curr2=head2;
         while(curr1!=null || curr2!=null)
         {
             if(curr1!=null)
             {
                 len1++;
                 curr1=curr1.next;
             }
             if(curr2!=null)
             {
                 len2++;
                 curr2=curr2.next;
             }
         }
         int diff=Math.abs(len2-len1);
         Node large=(len2>len1)?head2:head1;
         Node small=(len2>len1)?head1:head2;
         while(diff!=0)
         {
             large=large.next;
             diff--;
         }
         while(small!=null)
         {
             if(small==large)
               return small.data;
             small=small.next;
             large=large.next;
         }
         return -1;
	}
}