class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        x, y, z = target
        first = False
        second = False
        third = False

        for row in range(len(triplets)):
            a, b, c = triplets[row]
            if a > x or b > y or c > z:
                continue

            if a == x:
                first = True
            if b == y:
                second = True
            if c == z:
                third = True

            if first and second and third:
                return True

        return first and second and third
