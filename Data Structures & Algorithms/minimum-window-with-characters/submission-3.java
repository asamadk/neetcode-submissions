class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        if (t.length() == s.length() && t.equals(s)) {
            return t;
        }

        if (s.contains(t)) {
            return t;
        }

        HashMap<String,Integer> tFreq = countFreq(t);

        String minSubStr = null;
        
        int diff = s.length()-t.length();
        for (int i=0;i<=diff;i++) {
            for (int j=i+(t.length()-1);j<s.length();j++) {
                String subStr = s.substring(i,j+1);
                
                HashMap<String,Integer> sFreq = countFreq(subStr);
                if (matches(sFreq, tFreq)) {
                    if (
                        minSubStr == null || minSubStr.length() >= subStr.length()
                    ) {
                        minSubStr = subStr;
                    }
                }
            }
        }

        return minSubStr == null ? "" : minSubStr;
    }

    private boolean matches(
        HashMap<String,Integer> sFreq, 
        HashMap<String,Integer> tFreq
    ) {
        for (String key : tFreq.keySet()) {
            if (!sFreq.containsKey(key)) {
                return false;
            }
            if (sFreq.get(key) < tFreq.get(key)) {
                return false;
            }
        }
        return true;
    }

    private HashMap<String,Integer> countFreq(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            String key = s.charAt(i)+"";
            Integer count = 0;
            if (map.containsKey(key)) {
                count = map.get(key);
            }
            count++;
            map.put(key, count);
        }
        return map;
    }
}
