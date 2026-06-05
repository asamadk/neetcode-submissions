class KthLargest {
    int k;
    List<Integer> data;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.updateList(nums);
        this.updateQueue();
    }
    
    public int add(int val) {
        this.data.add(val);
        this.queue.add(val);
        
        int tmp = k;
        PriorityQueue<Integer> tmpQ = new PriorityQueue<>(this.queue);
        while (tmp > 1 && !tmpQ.isEmpty()) {
            tmpQ.poll();
            tmp--;
        }

        return tmpQ.poll();
    }

    private void updateList(int[] nums) {
        data = new ArrayList<Integer>();
        for (int i : nums) {
            data.add(i);
        }
    }

    private void updateQueue() {
        queue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer d : data) {
            queue.add(d);
        }
    }
}
