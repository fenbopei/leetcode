class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        
        //using map to create graph and group the nodes which share the same value but in different index;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                List<Integer> l1 = map.get(arr[i]);
                l1.add(i);
            }
            else {
                List<Integer> l2 = new ArrayList<>();
                l2.add(i);
                map.put(arr[i], l2);
            }
        }
        
        int minJump = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.offer(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int index = q.poll();
                if (index == len - 1) {
                    return minJump;
                }
                
                if (index > 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    q.offer(index - 1);
                }
                
                if (!visited[index + 1]) {
                    visited[index + 1] = true;
                    q.offer(index + 1);
                }
                
                //add all the index share the same value to the same layer;
                for (int idx : map.get(arr[index])) {
                    if (!visited[idx]) {
                        visited[idx] = true;
                        q.offer(idx);
                    }
                }
                
                // to avoid test case like 7, 7, 7 ,7, 7, all have the same value;
                map.get(arr[index]).clear();
            }
           
            ++minJump;
        }
        
        return minJump;
    }
}
