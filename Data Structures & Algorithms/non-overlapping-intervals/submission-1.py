class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        counter = 0
        n = len(intervals)
        idx = 0

        intervals.sort()

        while idx < n-1:
            c1, c2 = intervals[idx]
            n1, n2 = intervals[idx + 1]

            if n1 < c2:
                counter += 1
                intervals[idx+1] = [
                    min(c1,n1),
                    min(c2,n2)
                ]
            
            idx += 1

        return counter