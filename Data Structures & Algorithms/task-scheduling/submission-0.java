class Solution {
    class Pair {
        char ch;
        int freq;

        Pair(char ch,int freq) {
            this.ch = ch;
            this.freq = freq;
        }   
    }

    class Cooling {
        Pair p;
        int releaseTime;

        Cooling(Pair p, int releaseTime) {
            this.p = p;
            this.releaseTime = releaseTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = generateHeap(tasks);
        Queue<Cooling> q = new LinkedList<>();

        int cycle = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            cycle++;

            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                p.freq--;
                if (p.freq > 0) q.offer(new Cooling(p, cycle + n));
            }

            if (!q.isEmpty()) {
                Cooling cooling = q.peek();
                if (cooling.releaseTime == cycle) {
                    pq.add(cooling.p);
                    q.poll();
                }
            }
        }

        return cycle;
    }

    private PriorityQueue<Pair> generateHeap(char[] tasks) {
        Map<Character,Integer> freq = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.freq,a.freq)
        );

        for (char c:tasks) {
            Integer count = 0;
            if (freq.containsKey(c)) count = freq.get(c);
            count++;
            freq.put(c,count);
        }

        for (char key : freq.keySet()) {
            pq.add(new Pair(key,freq.get(key)));
        }

        return pq;
    }
}
