class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        int maxCount = 0;
        int pos = 0;
        while (pos < s.length()) {   
            HashSet<String> duplicate = new HashSet<>();
            int currentCount = 0;

            for (int i = pos; i < s.length(); i++) {
                String currentChar = s.charAt(i) + "";
                if (duplicate.contains(currentChar)) {
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                    }
                    currentCount = 1;
                } else {
                    duplicate.add(currentChar);
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
            pos++;
        }

        return maxCount;
    }
}
