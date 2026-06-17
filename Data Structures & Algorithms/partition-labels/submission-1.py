class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        ref = {}
        for i in range(len(s)-1, -1, -1):
           if s[i] not in ref:
            ref[s[i]] = i

        res = []
        size = 0
        end = 0
        for i in range(len(s)):
            size += 1
            end = max(end, ref[s[i]])

            if i == end:
                res.append(size)
                size = 0

        return res