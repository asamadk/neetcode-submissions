class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = self.generateAdj(edges)

        count = 0
        visited = set()

        for i in range(n):
            # print(f"range {i}")
            if i in visited:
                continue

            self.dfs(adj, visited, i)
            count += 1

        return count
    
    def dfs(self, adj, visited :set, cur :int):
        # print(f"dfs curr {cur}")
        if cur in visited:
            return
        
        visited.add(cur)

        if cur in adj:
            for i in adj[cur]:
                self.dfs(adj, visited, i)

        return

    def generateAdj(self, edges :List[List[int]]) -> list:
        map = {}

        for edge in edges:
            u = edge[0]
            v = edge[1]
            if u not in map:
                map[u] = [v]
            else:
                map[u].append(v)
            
            if v not in map:
                map[v] = [u]
            else:
                map[v].append(u)
        
        return map
