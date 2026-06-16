class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        totalGas = 0
        totalCost = 0

        for i in range(n):
            totalGas += gas[i]
            totalCost += cost[i]

        if totalCost > totalGas:
            return -1
        
        runningTank = 0
        idx = 0

        for i in range(n):
            runningTank += gas[i] - cost[i]
            
            if runningTank < 0:
                runningTank = 0
                idx = i + 1

        return idx
