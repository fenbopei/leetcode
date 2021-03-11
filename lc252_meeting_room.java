class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int length = intervals.length;
        //sorting by giving order;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < length; i++) {
            int end = intervals[i - 1][1];
            int nextStart = intervals[i][0];
            if (end > nextStart) {
                return false;
            }
        }
        
        return true;
    }
}
