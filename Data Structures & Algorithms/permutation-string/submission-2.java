class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<String,Integer> subStrFreq = getFreqMap(s1);
        int subLength = s1.length();

        for (int i=0;i<=s2.length() - s1.length();i++) {
            String sbStr = s2.substring(i,i+subLength);            
            HashMap<String,Integer> freq = getFreqMap(sbStr);
            if (freq.equals(subStrFreq)) {
                return true;
            }
        }

        return false;
    }

    private HashMap<String,Integer> getFreqMap(String str) {
        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0;i<str.length();i++) {
            Integer count = 0;
            String s = str.charAt(i)+"";
            if (map.containsKey(s)) {
                count = map.get(s);
            }   
            count++;
            map.put(s,count); 
        }

        return map;
    }
}
