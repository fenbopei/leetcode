class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        
        //dp[i][j] means if the substring beginning at index start and ending at index end is a plindrome;
        boolean[][] dp = new boolean[len][len];
        List<List<String>> res = new ArrayList<>();
        dfs(res, dp, s, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(List<List<String>> res, boolean[][] dp, String s, int start, List<String> sub) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(sub));        
        }
        
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                sub.add(s.substring(start, end + 1));
                dfs(res, dp, s, end + 1, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
