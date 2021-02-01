class Solution {
    Map<String, List<String>> graph = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> lb = new HashMap<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       if(!wordList.contains(endWord)) {
            return new LinkedList<>();
        }
        
        // build a dictionary of one edit words
        Map<String, Set<String>> dictionary = buildDictionary(beginWord, wordList);
        
        // bfs
        Map<String, Set<String>> graph = buildLadderGraph(beginWord, endWord, wordList, dictionary);
        
        // dfs all paths
        return traceAllPaths(graph, endWord, beginWord);
    }
    
    private Map<String, Set<String>> buildDictionary(String beginWord,List<String> wordList) {
        int wordLen = beginWord.length();
        Map<String, Set<String>> dict = new HashMap<>();
        for(String word : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String key = word.substring(0, i) + "-" + word.substring(i + 1, wordLen);
                dict.putIfAbsent(key, new HashSet<>());
                dict.get(key).add(word);
            }
        }
        return dict;
    }
    
    private Map<String, Set<String>> buildLadderGraph(String beginWord, String endWord, List<String> wordList, Map<String, Set<String>> dict) {                
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        Map<String, Set<String>> graph = new HashMap<>();        
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelVisits = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
    
                if(word.equals(endWord)) {
                    continue;
                }

                graph.putIfAbsent(word, new HashSet<>());
                
                int wordLen = beginWord.length();           
                for (int j = 0; j < wordLen; j++) {
                    String key = word.substring(0, j) + "-" + word.substring(j + 1, wordLen);
                    if(!dict.containsKey(key)) {
                        continue;
                    }
                    
                    for (String w : dict.get(key)) {
                        if(!visited.contains(w)) {
                            levelVisits.add(w);
                            queue.offer(w);
                            graph.get(word).add(w);
                        }
                    }
                }
            }
            
            for(String word : levelVisits) {
                visited.add(word);
            }
        }
        
        return graph;
    }
    
    private List<List<String>> traceAllPaths(Map<String, Set<String>> graph, String endWord, String node) {
        List<List<String>> result = new ArrayList<>();
        if(node.equals(endWord)) {
            result.add(new ArrayList<>());
            result.get(0).add(node);
            return result;
        }
        
        if(!graph.containsKey(node) || graph.get(node).size() == 0) {
            return result;
        }
        
        for(String child : graph.get(node)) {
            List<List<String>> childRes = traceAllPaths(graph, endWord, child);
            for(List<String> list : childRes) {
                list.add(0, node);
                result.add(list);
            }
        }
        
        return result;
    }
}
