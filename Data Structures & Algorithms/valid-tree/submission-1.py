class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # Checking edges, if edges != n-1 its not a tree
        if len(edges) != n-1:
            return False
        
        if len(edges) == 0:
            return True

        adj = defaultdict(list)

        # Creating adjecency list
        for edge in edges:
            u = edge[0]
            v = edge[1]

            adj[u].append(v)
            adj[v].append(u)
        
        # Starting from any root and it should access all nodes
        root = edges[0][0]
        visited = set()
        self.dfs(adj, visited, root)

        return len(visited) == n;

    def dfs(self, adj, visited :set, root :int):
        if (root in visited):
            return
        
        visited.add(root)
        
        for l in adj[root]:
            self.dfs(adj, visited, l)
        

        return
        