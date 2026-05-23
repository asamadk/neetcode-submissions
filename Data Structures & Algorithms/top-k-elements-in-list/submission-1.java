class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int i=0;i<nums.length;i++) {
            if (freq.containsKey(nums[i])) {
                Integer tmp = freq.get(nums[i]);
                tmp++;
                freq.put(nums[i], tmp);
            } else {
                freq.put(nums[i], 1);
            }
        }

        HashMap<Integer, List<Integer>> freqList = new HashMap<>();
        
        for (Integer key : freq.keySet()) {
            Integer value = freq.get(key);
            if (freqList.containsKey(value)) {
                List<Integer> tmp = freqList.get(value);
                tmp.add(key);
                freqList.put(value, tmp);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(key);
                freqList.put(value, tmp);
            }
        }

        for(Integer key : freqList.keySet()) {
            q.add(key);
        }

        List<Integer> tmpResult = new ArrayList<>();

        while(k > 0) {
            Integer key = q.poll();
            List<Integer> res = freqList.get(key);
            for (int i=0;i<res.size();i++) {
                tmpResult.add(res.get(i));
            }
            k = k - res.size();
        }

        int[] result = new int[tmpResult.size()];
        for (int i=0;i<tmpResult.size();i++) {
            result[i] = tmpResult.get(i);
        }
        return result;
    }
}
