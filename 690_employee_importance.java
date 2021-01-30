class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //need to map the employeed id and their location in the list;
        int res = 0;
        if (employees == null || id < 1) {
            return res;
        }
        
        //pay attention to here, otherwise can't find where to start;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        /*
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while (!q.isEmpty()) {
            Employee cur = q.poll();
            List<Integer> subs = cur.subordinates;
            for (int sub : subs) {
                //System.out.println("*" + sub);
                q.add(map.get(sub));
            }
            
            res += cur.importance;  
        }
        
        return res;
        */
        // using dfs
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int eid) {
        Employee e = map.get(eid);
        int res = e.importance;
        for (int subId : e.subordinates) {
            res += dfs(map, subId);
        }
        
        return res;
    }
}
