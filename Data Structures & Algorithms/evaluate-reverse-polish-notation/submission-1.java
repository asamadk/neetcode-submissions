class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens) {
            if (
                token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")
            ) {
                int first = stack.pollLast();
                int second = stack.pollLast();
                int calc;
                if (token.equals("+")) {
                    calc = first + second;
                } else if (token.equals("-")) {
                    calc = second - first;
                } else if (token.equals("*")) {
                    calc = first * second;
                } else {
                    calc = second / first;
                }
                stack.offerLast(calc);
            } else {
                stack.offerLast(Integer.valueOf(token));
            }
        }

        return stack.pollLast();
    }
}
