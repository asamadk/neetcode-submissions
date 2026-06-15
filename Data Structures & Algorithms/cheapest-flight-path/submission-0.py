class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = {}

        for flight in flights:
            s,d,p = flight
            if s not in adj:
                adj[s] = []
            
            adj[s].append([d,p])

        priceMap = {}
        for i in range(0, n):
            priceMap[i] = sys.maxsize

        priceMap[src] = 0

        stopMap = {}
        for i in range(0, n):
            stopMap[i] = sys.maxsize
        stopMap[src] = 0

        q = deque()
        q.append([src, 0, 0])

        while len(q) > 0:
            cur, price, stop = q.popleft();

            if stop > k:
                continue
            
            if cur not in adj:
                continue

            for neighbour in adj[cur]:
                next_point, next_price = neighbour
                total_price = price + next_price
                
                if total_price < priceMap[next_point] or stop + 1 < stopMap[next_point]:

                    if total_price < priceMap[next_point]:
                        priceMap[next_point] = total_price

                
                    q.append([next_point, total_price, stop + 1])
                    stopMap[next_point] = stop + 1

        if priceMap[dst] == sys.maxsize:
            return -1

        return priceMap[dst]