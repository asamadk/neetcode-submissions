class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        n,m = len(matrix), len(matrix[0])

        for row in range(n):
            for col in range(m):
                if matrix[row][col] == 0:
                    for i in range(m):
                        if matrix[row][i] != 0: 
                            matrix[row][i] = sys.maxsize * -1
                    
                    for i in range(n):
                        if matrix[i][col] != 0: 
                            matrix[i][col] = sys.maxsize * -1
        
        for row in range(n):
            for col in range(m):
                if matrix[row][col] == sys.maxsize * -1:
                    matrix[row][col] = 0