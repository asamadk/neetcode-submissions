class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = sys.maxsize * -1
        curSum = 0

        for num in nums:
            if curSum < 0:
                curSum = 0

            curSum += num
            maxSum = max(maxSum, curSum)

        return maxSum
