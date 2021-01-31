class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        //using map to record visited status and steps;
        Map<String, Integer> map = new HashMap<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            System.out.println(cur);

            //System.out.println("next size " + nexts.size());
             for (String next : getNext(dict, cur)) {
                if (next.equals(endWord)) {
                    return map.get(cur) + 1;
                }
            
                if (map.containsKey(next)) {
                 continue;
                }
            
                map.put(next, map.get(cur) + 1);
                q.offer(next);
            }
        }
        
        return 0;
        
    }
    
    private List<String> getNext(Set<String> dict, String cur) {
        List<String> res = new ArrayList<>();
        System.out.println("*" + cur);
        for (int i = 0; i < cur.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == cur.charAt(i)) {
                    continue;
                }
                
                String next = cur.substring(0, i) + ch + cur.substring(i + 1);
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
        }
        
        //System.put
        return res;
    }
}
