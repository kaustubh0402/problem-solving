https://leetcode.com/problems/flatten-nested-list-iterator/
//Problem no : 341

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> store=new ArrayList<>();
    int i=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    void helper(List<NestedInteger> nestedList)
    {
        for(NestedInteger curr: nestedList)
        {
            if(curr.isInteger())
                store.add(curr.getInteger());
            else
                helper(curr.getList());
        }
    }
    @Override
    public Integer next() {
        Integer val=store.get(i);
        i++;
        return val;
    }

    @Override
    public boolean hasNext() {
        if(i==store.size())
            return false;
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */