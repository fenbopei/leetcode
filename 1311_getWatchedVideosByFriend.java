class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> ans = new ArrayList<>();
        int steps = 0;
        
        //adding id to the queue;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[watchedVideos.size()];
        q.add(id);
        visited[id] = true;
        
        while(!q.isEmpty()) {
            if (steps == level) {
                break;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curId = q.poll();
                int[] children = friends[curId];
                for (int child : children) {
                    //System.out.println("*" + child);
                    if (!visited[child]) {
                        q.add(child);
                        visited[child] = true;
                    }
                }
            }
            
            steps++;
        }

        //count movie here;
        Map<String, Integer> movieCount = new HashMap<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur);
            List<String> movies = watchedVideos.get(cur);
            for (String movie : movies) {
                movieCount.put(movie, movieCount.getOrDefault(movie, 0) + 1);
            }
        }
        
        for (String s : movieCount.keySet()) {
            ans.add(s);
        }
        
        Collections.sort(ans, (a, b) -> {
            if (movieCount.get(a) == movieCount.get(b)) {
                return a.compareTo(b);
            }
            
            return movieCount.get(a) - movieCount.get(b);
        });
        
        return ans;
    }
}
