class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        //adding all trees to pq for search 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int m = 0; m < forest.size(); m++) {
            for (int n = 0; n < forest.get(m).size(); n++) {
                int height = forest.get(m).get(n);
                if (height > 1) {
                    pq.offer(new int[]{m, n, height});
                }
            }   
        }
        
        int ans = 0;
        int[] prev = new int[]{0, 0};
        //loop through the tree set to find a way for every two trees and add them together to get the answer;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int step = bfs(prev, cur, forest);
            if (step < 0) {
                return -1;
            }
            ans += step;
            prev[0] = cur[0];
            prev[1] = cur[1];
        }
        
        return ans;   
    }
    
    private int bfs(int[] start, int[] end, List<List<Integer>> forest) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[start[0]][start[1]] = true;
        int step = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return step;
                }
                
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dir[j][0];
                    int newY = cur[1] + dir[j][1];
                    if (isValid(newX, newY, forest, visited)){
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }    
            }
            
            step++;
        }
        
        return -1;    
    }
    
    private boolean isValid(int x, int y, List<List<Integer>> forest, boolean[][] visited) {
        return (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(0).size() && forest.get(x).get(y) > 1 && !visited[x][y]);
    }
}
