class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        int len = intervals.length;
        int i = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        /*
        if (intervals.length == 0) {
            ans.add(newInterval);
            
        }*/
        int[] interval = new int[2];
            
        while (i < len && newStart > intervals[i][0]) {
            ans.add(intervals[i++]);
        }
        
        //when out from the loop, there are two cases
        if (ans.isEmpty() || newStart > ans.getLast()[1]) {
            ans.add(newInterval);
        }
        else{
            interval = ans.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            ans.add(interval);
        }
        
        //need to merge with the first interval which is larger;
        while (i < len) {
            interval = intervals[i++];
            int start2 = interval[0];
            int end2 = interval[1];
            
            if (start2 > ans.getLast()[1]) {
                ans.add(interval);
            }
            else{
                interval = ans.removeLast();
                interval[1] = Math.max(interval[1], end2);
                ans.add(interval);
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
