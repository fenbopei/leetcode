class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        List<String>[] dp = new ArrayList[n + 1];
        return dfs(s, 0, dict, dp);
    }
    
    private List<String> dfs(String s, int i, Set<String> dict, List<String>[] dp) {
        if (dp[i] != null) {
            return dp[i];
        }
        
        if (i == s.length()) {
            return Arrays.asList("");
        }
        
        List<String> res = new ArrayList<>();
        for (int j = i + 1; j <= s.length(); j++) {
            String cur = s.substring(i, j);
            if (dict.contains(cur)) {
                List<String> next = dfs(s, j, dict, dp);
                if (!next.isEmpty()) {
                    for (String suffix : next) {
                        res.add(cur + (suffix.equals("") ? "" : " ") + suffix);
                    }
                }
            }
            
            
        }
        
        dp[i] = new ArrayList<>();
        dp[i] = res;
        return res;    
    }
}
