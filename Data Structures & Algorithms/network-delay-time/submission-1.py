class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        q = deque()
        q.append([k, 0])

        adj = {}
        for time in times:
            u = time[0]
            v = time[1]
            weight = time[2]

            if u not in adj:
                adj[u] = []
            
            adj[u].append([v,weight])

        delayMap = {}
        for i in range(1,n+1):
            delayMap[i] = sys.maxsize
        
        delayMap[k] = 0

        while len(q) > 0 :
            cur, weight = q.popleft()

            if cur not in adj:
                continue

            for neighbour in adj[cur]:
                val = neighbour[0]

                totalDelay = neighbour[1] + weight
                
                if (totalDelay < delayMap[val]):
                    q.append([val, totalDelay])
                    delayMap[val] = min(delayMap[val], totalDelay)

        max_delay = 0
        for node in range(1, n + 1):
            if delayMap[node] == sys.maxsize:
                return -1
            max_delay = max(max_delay, delayMap[node])

        return max_delay