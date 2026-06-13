class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        adj = {}
        for u, v in edges:
            if u not in adj:
                adj[u] = []
            if v not in adj:
                adj[v] = []
            
            visited = set()
            if self.dfs(adj, u, v, visited, -1) == True:
                return [u,v]

            adj[u].append(v)
            adj[v].append(u)

    def dfs(self, adj, cur: int, target: int, visited: set, parent: int) -> bool:
        if cur == target:
            return True

        visited.add(cur)

        if cur in adj:
            for i in adj[cur]:
                if i == parent or i in visited:
                    continue

                if self.dfs(adj, i, target, visited, cur):
                    return True

        return False
