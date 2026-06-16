class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        freqMap = {}
        for h in hand:
            if h not in freqMap:
                freqMap[h] = 0
            freqMap[h] += 1

        hand = list(set(hand))
        hand.sort()

        if len(hand) < groupSize:
            return False

        while (len(freqMap) > 0):
            tmp = []

            counter = 0
            for h in hand:
                if counter == groupSize:
                    break
                
                if h not in freqMap:
                    continue

                tmp.append(h)
                freqMap[h] -= 1
                counter += 1

                if freqMap[h] == 0:
                    del freqMap[h]    
            
            if len(tmp) < groupSize:
                return False
            
            for i in range(len(tmp)-1):
                if (tmp[i+1] - tmp[i] > 1):
                    return False
        
        return True
