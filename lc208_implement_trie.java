class Trie {

    /** Initialize your data structure here. */
   private TrieNode root;

   public Trie(){
       root = new TrieNode();
   }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        /*
        loop through every char in word, unitl the end*/
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            
            cur = cur.children[word.charAt(i) - 'a'];
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        //return searchStr(word, true);
        //search until all the characters in the word is find;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            else{
                cur = cur.children[word.charAt(i) - 'a'];
            }
        }
        
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            else{
                cur = cur.children[index];
            }    
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

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
