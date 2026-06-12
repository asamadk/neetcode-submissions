class Solution {
    List<Integer> res;
    Set<Integer> logged;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] pre : prerequisites) {
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }

        res = new ArrayList<>();
        logged = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            if (!dfs(i, adjList, visited))
                return new int[0];
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int cur, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(cur))
            return false;
        if (logged.contains(cur))
            return true;

        visited.add(cur);

        if (!adjList.containsKey(cur)) {
            visited.remove(cur);
            if (!logged.contains(cur)) {
                logged.add(cur);
                res.add(cur);
            }
            return true;
        }

        List<Integer> tmp = adjList.get(cur);
        if (tmp.size() == 0) {
            visited.remove(cur);
            if (!logged.contains(cur)) {
                logged.add(cur);
                res.add(cur);
            }
            return true;
        }

        for (Integer t : tmp) {
            boolean res = dfs(t, adjList, visited);
            if (!res)
                return false;
        }

        visited.remove(cur);
        if (!logged.contains(cur)) {
            logged.add(cur);
            res.add(cur);
        }
        return true;
    }
}
