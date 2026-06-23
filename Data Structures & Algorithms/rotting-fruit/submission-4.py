class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque([])
        fresh = 0

        n,m = len(grid), len(grid[0])
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 2:
                    queue.append([i,j])
                if grid[i][j] == 1:
                    fresh += 1

        if fresh == 0:
            return 0

        minutes = 0
        while len(queue) > 0 and fresh > 0:
            minutes += 1
            for i in range(len(queue)):
                row, col = queue.popleft()

                if row + 1 < n and grid[row + 1][col] == 1:
                    fresh -= 1
                    grid[row+1][col] = 2
                    queue.append([row+1, col])
                
                if row - 1 >= 0 and grid[row - 1][col] == 1:
                    fresh -= 1
                    grid[row-1][col] = 2
                    queue.append([row-1, col])
                
                if col + 1 < m and grid[row][col + 1] == 1:
                    fresh -= 1
                    grid[row][col+1] = 2
                    queue.append([row, col + 1])
                
                if col - 1 >= 0 and grid[row][col - 1] == 1:
                    fresh -= 1
                    grid[row][col-1] = 2
                    queue.append([row, col - 1])

        if fresh == 0:
            return minutes

        return -1