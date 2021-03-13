https://leetcode.com/problems/find-median-from-data-stream/
//Problem no : 295

/*
We will maintain two heap
1. max heap of minimum of n/2 elements
2. min heap of maximum of n/2 elements

max heap of n/2 min elemnts                   min heap of n/2 max elemnts
    1  4  6  7                                            9  10  8  11
							
Now our task is to check if n is even or odd
suppose size of min heap==size of max heap
then n will be even
then we will ouput median as average of top of both heaps

else
we will output elemnt from max heap

Why we are printing elemnt from max heap??
Beacuse There is possiblity that n will not be even
so while implementing we have to maintain max heap size always grater than min heap
*/



class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max=new PriorityQueue<>((x,y)->y-x);
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
		//Add input elemnt to max heap
        max.add(num);
		//Now add greatest of  max heap in min heap to balance heap 
        min.add(max.remove());
				
		//Now we have to maintainn size of max heap grater than min heap
        if(max.size()<min.size())
            max.add(min.remove());
    }
    
    public double findMedian() {
        if(max.size()==min.size())
            return (max.peek()+min.peek())/2.0;
        else
            return max.peek();
    }
}