class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<Integer>();
        this.minStack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if (this.stack.size() == 1) {
            this.minStack.add(val);
        } else {
            if (val < this.minStack.get(this.minStack.size() - 1)) {
                this.minStack.add(val);
            } else {
                this.minStack.add(
                    this.minStack.get(this.minStack.size() - 1)
                );
            }
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        this.minStack.remove(this.minStack.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        if (this.minStack.size() <= 0) {
            return 0;
        }
        return this.minStack.get(this.minStack.size() - 1);
    }
}
