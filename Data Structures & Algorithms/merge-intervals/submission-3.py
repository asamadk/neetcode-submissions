class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        idx = 0

        intervals.sort()
        
        # Add intervals which are non overlapping
        while idx < n-1:
            # Handle last interval
            # if (idx == n -1):
                # res.append(intervals[idx])
                # break

            c1,c2 = intervals[idx]
            n1, n2 = intervals[idx + 1]
            # Merge intervals
            if n1 <= c2:
                tmpVal = [min(c1, n1), max(c2,n2)]
                intervals[idx] = []
                intervals[idx + 1] = tmpVal
                # res.append(tmpVal)
                # idx += 1
            # Append non over lapping intervals
            # else:
                # res.append([c1, c2])
            idx += 1
        
        res = []
        # print(intervals)
        for interval in intervals:
            if len(interval) > 0:
                res.append(interval)
    
        return res