class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        idx = 0

        intervals.sort()
        
        while idx < n-1:
            c1,c2 = intervals[idx]
            n1, n2 = intervals[idx + 1]
            
            if n1 <= c2:
                tmpVal = [min(c1, n1), max(c2,n2)]
                intervals[idx] = []
                intervals[idx + 1] = tmpVal
                
            idx += 1
        
        res = []
        for interval in intervals:
            if len(interval) > 0:
                res.append(interval)
    
        return res