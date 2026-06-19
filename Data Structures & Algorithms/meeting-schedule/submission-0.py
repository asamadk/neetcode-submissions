"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key = lambda emp: emp.start)
        idx = 0
        n = len(intervals)
        while idx < n-1:
            currentInterval = intervals[idx]
            nextInterval = intervals[idx + 1]

            if (nextInterval.start < currentInterval.end):
                return False
            
            idx += 1

        return True
