class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        
        visited = set()
        
        min_heap = []
        heapq.heappush(min_heap, [0, 0])

        total_count = 0

        while (len(visited) < n):
            weight, point = heapq.heappop(min_heap)
            x1, y1 = points[point]

            if point in visited:
                continue

            total_count += weight
            visited.add(point)

            for i in range(0, n, 1):
                if i in visited:
                    continue
                    
                x2, y2 = points[i]

                distance = abs(x1-x2) + abs(y1 - y2)

                heapq.heappush(min_heap, [distance, i])

        return total_count