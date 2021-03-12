class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][2];
        }
        
        Arrays.sort(intervals, (w1, w2) -> w1[0] - w2[0]);
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            }
            else if (ans.getLast()[1] >= interval[0]) {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);   
        /*
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] top = stack.peek();
            if (cur[0] <= top[1]) {
                if (cur[1] >= top[1] ) {
                    stack.pop();
                    stack.push(new int[]{top[0], cur[1]});
                }
            }
            else if (cur[0] > top[1]) {
                stack.push(cur);
            }
        }
        
        //change stack to array;
        System.out.println(stack.size());
        int[][] res = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;*/
    }
}
