class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character, char[]> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        dfs(digits, "", 0);
        return ans;
    }
    
    private void dfs(String digits, String combination, int startIndex) {
        if (combination.length() == digits.length()) {
            ans.add(combination);
            return;
        }
        
        char[] chars = map.get(digits.charAt(startIndex));
        for (char ch : chars) {
            String newStr = combination + ch;
            dfs(digits, newStr, startIndex + 1);
        }
    }
}
