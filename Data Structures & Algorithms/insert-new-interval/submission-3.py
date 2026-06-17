class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)

        i = 0
        output = []

        while i < n and intervals[i][1] < newInterval[0]:
            output.append(intervals[i])
            i += 1

        while i < n and newInterval[1] >= intervals[i][0]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1

        output.append(newInterval)

        while i < n:
            output.append(intervals[i])
            i += 1
        
        return output