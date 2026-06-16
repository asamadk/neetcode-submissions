class Solution:
    def canJump(self, nums: List[int]) -> bool:
        i = 0
        n = len(nums)

        while i < n:
            if i < n - 1 and nums[i] == 0:
                return False

            if i >= n - 1:
                break

            if nums[i] == 1:
                i += 1
                continue

            curMax = i + nums[i]
            maxIdx = i

            for j in range(i + 1, i + nums[i] + 1):
                if j >= n - 1:
                    return True

                if j + nums[j] >= curMax:
                    curMax = j + nums[j]
                    maxIdx = j

            if maxIdx == i:
                return False

            i = maxIdx

        return True
