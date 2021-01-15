class Solution {
    public int openLock(String[] deadends, String target) {
        //initial data structures;
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        
        //use bfs to find the shortest path;
        int minTurn = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return minTurn;
                }
                for (int j = 0; j < 4; j++) {
                    int down = (cur.charAt(j) - '0' + 1) % 10;
                    int up = (cur.charAt(j) - '0' - 1) == -1 ? 9 : (cur.charAt(j) - '0' - 1);
                    String nextDown = cur.substring(0, j) + down + cur.substring(j + 1, 4);
                    String nextUp = cur.substring(0, j) + up + cur.substring(j + 1, 4);
                    
                    if (!visited.contains(nextDown) && !dead.contains(nextDown)) {
                        visited.add(nextDown);
                        q.offer(nextDown);
                    }
                    if (!visited.contains(nextUp) && !dead.contains(nextUp)) {
                        visited.add(nextUp);
                        q.offer(nextUp);
                    }
                }
            }
            
            minTurn++;
        }
        
        return -1;
    }  
}
