https://leetcode.com/problems/implement-trie-prefix-tree/
//Problem no : 208

//Source : Leetcode tutorial
/*
Insert sudo algo:
1. Initialize: cur = root
2. for each char c in target string S:
3.      if cur does not have a child c:
4.          cur.children[c] = new Trie node
5.      cur = cur.children[c]
6. cur is the node which represents the string S
*/

/*
Search Prefix
As we mentioned in the introduction to Trie, all the descendants of a node have a common prefix of the string associated with that node.
 Therefore, it should be easy to search if there are any words in the trie that starts with the given prefix.

Similarly, we can go down the tree depending on the given prefix. 
Once we can not find the child node we want, search fails.
 Otherwise, search succeeds. To be more specific
 
Let's summarize the strategy using pseudo-code:

1. Initialize: cur = root
2. for each char c in target string S:
3.   if cur does not have a child c:
4.     search fails
5.   cur = cur.children[c]
6. search successes


Search Word
You might also want to know how to search for a specific word rather than a prefix. 
We can treat this word as a prefix and search in the same way we mentioned above.

If search fails which means that no words start with the target word,
 the target word is definitely not in the Trie.

If search succeeds, we need to check if the target word is only a prefix of words in Trie 
or it is exactly a word. To solve this problem, you might want to modify the node structure a little bit.

Hint: A boolean flag in each node might work.

*/

class Trie {

    class node
    {
        node children[]=new node[26];
        int end=0;
    }
    
    node root;
    public Trie() {
        root=new node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        node curr=root;
        int n=word.length();
        int i=0;
        while(i!=n)
        {
            int now=word.charAt(i)-97;
            if(curr.children[now]==null)
                curr.children[now]=new node();
            curr=curr.children[now];
            i++;
        }
        curr.end=1;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        node curr=root;
        int n=word.length();
        int i=0;
        while(i!=n)
        {
            int now=word.charAt(i)-97;
            if(curr.children[now]==null)
                return false;
            curr=curr.children[now];
            i++;
        }
               
        return curr.end==1;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        node curr=root;
        int n=prefix.length();
        int i=0;
        while(i!=n)
        {
            int now=prefix.charAt(i)-97;
            if(curr.children[now]==null)
                return false;
            curr=curr.children[now];
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */