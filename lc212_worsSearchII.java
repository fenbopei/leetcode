class Solution {
    private TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        int m = board.length, n = board[0].length;
        List<String> res = new ArrayList<>();
        for (String s : words) {
            buildTriTree(s);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }   
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return;
        }
        
        char c = board[i][j];
        node = node.next[c - 'a'];
        if (node == null) {
            return;
        }
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        board[i][j] = '*';
        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
        
    }
    public class TrieNode{
        TrieNode[] next;
        String word;
        
        public TrieNode(){
            next = new TrieNode[26];
            word = null;
        }
    }
    
    public void buildTriTree(String w) {
        TrieNode node = root;
        for (int i = 0; i < w.length(); i++) {
            if (node.next[w.charAt(i) -'a'] == null) {
                node.next[w.charAt(i) - 'a'] = new TrieNode();
            }
            
            node = node.next[w.charAt(i) - 'a'];
        }
        
        node.word = w;
    }
}
