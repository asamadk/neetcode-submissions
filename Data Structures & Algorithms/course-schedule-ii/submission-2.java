class Solution {
    List<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] pre : prerequisites) {
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }

        int[] state = new int[numCourses];
        res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, adjList, state))
                    return new int[0];
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(
        int cur, 
        Map<Integer, List<Integer>> adjList, 
        int[] state
    ) {
        if (state[cur] == 1) return false;
        if (state[cur] == 2) return true;

        state[cur] = 1;

        if (adjList.containsKey(cur)) {
            for (Integer t : adjList.get(cur)) {
                boolean res = dfs(t, adjList, state);
                if (!res) return false;
            }
        }

        state[cur] = 2;
        res.add(cur);
        return true;
    }
}
