class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strs.size();i++) {
            String str = strs.get(i);
            if (str.equals("")) {
                sb.append("j");
            }
            for (int j=0;j<str.length();j++) {
                int cInt = (int) str.charAt(j);
                sb.append(String.valueOf(cInt));
                if (j < str.length() - 1) {
                    sb.append("x");
                }
            }
            if (i < strs.size() - 1) {
                    sb.append("y");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str.equals("")) {
            return result;
        }
        System.out.println(str);
        String[] words = str.split("y");

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (String letter : word.split("x")) {
                if (letter.equals("j")){
                    sb.append(""); 
                } else {
                    String character = String.valueOf((char) Integer.parseInt(letter));
                    sb.append(character);
                }
            }
            result.add(sb.toString());
        }

        
        return result;
    }
}
