class Solution:
    def jump(self, nums: List[int]) -> int:
        i = 0
        n = len(nums)

        if (n == 1):
            return 0

        minCount = 1
        while(i < n):
            maxJump = nums[i]
            maxIdx = i
            for j in range(i +1 ,i+nums[i]+1):
                if (j >= n -1):
                    return minCount
                
                if (j + nums[j] > maxJump):
                    maxJump = j + nums[j]
                    maxIdx = j
            
            # if (maxIdx == i):
            i = maxIdx
            minCount += 1
        
        return minCount

                