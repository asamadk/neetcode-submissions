class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<String, Integer> freq = generateFreqMap(s);

        int maxCount = 0;
        for (int pos=0;pos<s.length();pos++) {
            // Iterate over frequency map
            for (String key : freq.keySet()) {
                int tempK = k;
                StringBuilder tmpS = new StringBuilder(s);
                for (int i = pos; i < tmpS.length(); i++) {
                    String crr = tmpS.charAt(i) + "";
                    if (!crr.equals(key) && tempK > 0) {
                        tmpS.setCharAt(i, key.charAt(0));
                        tempK--;
                    }
                    int count = longestSameCharSubstring(tmpS.toString());
                    maxCount = Math.max(count,maxCount);
                }
            }
        }

        return maxCount;
    }

    private int longestSameCharSubstring(String s) {
        // System.out.println(s);
        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
        }
        // System.out.println(maxCount);
        // System.out.println("--------------");
        
        return maxCount;
    }

    private HashMap<String, Integer> generateFreqMap(String s) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String crr = s.charAt(i) + "";
            Integer count = 0;
            if (freq.containsKey(crr)) {
                count = freq.get(crr);
            }
            count++;
            freq.put(crr, count);
        }

        return freq;
    }
}
