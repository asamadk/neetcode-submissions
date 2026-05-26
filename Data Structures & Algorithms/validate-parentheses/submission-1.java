class Solution {
    public boolean isValid(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++) {
            String str = s.charAt(i)+"";
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.push(str);
            } else {
                boolean empty = stack.isEmpty();
                if (!empty && stack.peek().equals("(") && str.equals(")")) {
                    stack.pop();
                } else if (!empty && stack.peek().equals("[") && str.equals("]")) {
                    stack.pop();
                } else if (!empty && stack.peek().equals("{") && str.equals("}")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
