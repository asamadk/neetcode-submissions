class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
         for (int i=0;i<strs.length;i++) {
            String currentFingerprint = fingerprint(strs[i]);
            List<String> mapList = map.get(currentFingerprint);
            if (mapList == null) {
                mapList = new ArrayList<String>();
            }
            mapList.add(strs[i]);
            map.put(currentFingerprint, mapList);
        }

        List<List<String>> result = new ArrayList<>();
        map.forEach((key, value) -> {
            result.add(value);
        });
        return result;
    }

    private String fingerprint(String str) {
        int[] frequency = new int[26];
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            frequency[c - 'a']++;
        }
        String result = "";
        for(int i=0;i<frequency.length;i++) {
            if (frequency[i] > 0) {
                result += i+"_"+frequency[i];
            }
        }
        return result;
    }
}
