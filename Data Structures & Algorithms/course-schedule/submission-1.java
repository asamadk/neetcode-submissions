class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] pre :prerequisites) {
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }

        for (int i=0;i<numCourses;i++) {
            Set<Integer> visited = new HashSet<>();
            boolean finished = dfs(i, adjList, visited);
            if (!finished) return false;
        }

        return true;
    }

    private boolean dfs(
        Integer cur, 
        Map<Integer, List<Integer>> adjList,
        Set<Integer> visited
    ) {
        if (visited.contains(cur)) {
            return false;
        };

        visited.add(cur);

        if (!adjList.containsKey(cur)) {
            visited.remove(cur);
            return true;
        }

        List<Integer> list = adjList.get(cur);
        if (list.size() == 0) {
            visited.remove(cur);
            return true;
        }

        for (Integer i: list) {
            boolean tmp = dfs(i, adjList, visited);
            if (!tmp) return false;
        }

        visited.remove(cur);
        return true;
    }
}
