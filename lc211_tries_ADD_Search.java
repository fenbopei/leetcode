class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(TrieNode root, String word, int index) {
        if (root == null || index > word.length()) return false;
        if (index == word.length()) return root.isWord;

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : root.children) {
                boolean res = search(child, word, index + 1);
                if (res == true) return true;
            }
            return false;
        }

        return search(root.children[c - 'a'], word, index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class TrieNode {
        //char val;
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            //this.val = val;
            this.children = new TrieNode[26];
        }
}
