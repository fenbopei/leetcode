class Solution {
    class Path {
        int x, y, dist;
        String path;
        public Path(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
        @Override
        public String toString() {
            return x + " " + y + " " + dist + " " + path;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        PriorityQueue<Path> q = new PriorityQueue<>((a, b) -> {
            if (a.dist == b.dist) { 
                return a.path.compareTo(b.path);
            } else {
                return a.dist - b.dist;
            }
        });
        Set<Integer> visited = new HashSet<>();
        q.offer(new Path(ball[0], ball[1], 0, ""));
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] ways = {"d", "u", "r", "l"};
        while (!q.isEmpty()) {
            Path cur = q.poll();
            //System.out.println(cur);
            if (cur.x == hole[0] && cur.y == hole[1]) return cur.path;
            if (!visited.add(cur.x * n + cur.y)) continue;
            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int x = cur.x, y = cur.y, k = 0;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    k++;
                    if (x == hole[0] && y == hole[1]) {
                        q.offer(new Path(x, y, cur.dist + k, cur.path + ways[i]));
                        break;
                    } else {
                        x += dir[0];
                        y += dir[1];
                    }
                }
                x -= dir[0];
                y -= dir[1];
                k--;
                q.offer(new Path(x, y, cur.dist + k, cur.path + ways[i]));
            }
        }
        return "impossible";        
    }
}
