class Solution {
    Trie root = new Trie();
    String[] dict;
    public List<List<Integer>> palindromePairs(String[] words) {
        dict = words;
        List<List<Integer>> res = new ArrayList<>();
        int len = words.length;
        if (len < 2) {
            return res;
        }
        
        for (int i = 0; i < len; i++) {
            insert(i);
        }
        
        for(int i=0; i<len; i++){
            if(dict[i].length()==0){
                for(int j=0; j<len; j++){
                    if(i!=j && isPalindrome(j, 0, dict[j].length()-1)){
                        res.add(Arrays.asList(i, j));
                        res.add(Arrays.asList(j, i));
                    }
                }
            }else
                for(int p : search(i))
                    res.add(Arrays.asList(i, p));
        }
        
        return res;
    }
    
        public void insert(int index){
        int len = dict[index].length();
        char[] warr = dict[index].toCharArray();
        Trie node = root;
        for(int i=len-1; i>=0; i--){
            if(node.children[warr[i]-'a']==null)
                node.children[warr[i]-'a'] = new Trie();
            node.children[warr[i]-'a'].idxes.add(index);
            node = node.children[warr[i]-'a'];
        }
    }
    public Set<Integer> search(int idx){
        String word = dict[idx];
        int len = word.length();
        Trie node = root;
        Set<Integer> res = new HashSet();
        int i=0;
        for(; i<len; i++){
            Trie next = node.children[word.charAt(i)-'a'];
            if(next == null) break;
            for(int ol : next.idxes)
                if(ol!=idx && i+1==dict[ol].length() && isPalindrome(idx, i+1, len-1))
                    res.add(ol);
            node = next;
        }
        if(i==len){
            List<Integer> overlaps = node.idxes;
            for(int ol : overlaps){
                if(ol == idx || res.contains(ol)) continue;
                if(isPalindrome(ol, 0, dict[ol].length()-len-1))
                    res.add(ol);
            }
        }
        return res;
    }
    public boolean isPalindrome(int idx, int l, int r){
        while(l<r)
            if(dict[idx].charAt(l++)!=dict[idx].charAt(r--))
                return false;
        return true;
    }    
}




class Trie{
    Trie[] children;
    List<Integer> idxes;
    
    public Trie(){
        idxes = new ArrayList<>();
        children = new Trie[26];
    }
}
