class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> q = new PriorityQueue<>();
        Map<Double, List<List<Integer>>> map = new HashMap<>();

        for (int i=0;i<points.length;i++) {
            double dis = getDistance(points[i][0], points[i][1]);
            q.add(dis);
            List<List<Integer>> temp = new ArrayList<>();
            if (map.containsKey(dis)) {
                temp = map.get(dis);
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(points[i][0]);
            tmp.add(points[i][1]);
            temp.add(tmp);
            map.put(dis, temp);
        }

        int[][] res = new int[k][2];
        int idx=0;
        while (k > 0) {
            Double dis = q.poll();
            List<List<Integer>> tmp = map.get(dis);
            List<Integer> cord = tmp.get(0);
            
            res[idx][0] = cord.get(0);
            res[idx][1] = cord.get(1);
            tmp.remove(0);
            map.put(dis, tmp);
            
            idx++;
            k--;
        }

        return res;
    }

    private double getDistance(int x2, int y2) {
        int x1 = 0;
        int y1 = 0;

        return Math.hypot(x1 - x2, y1 - y2);
    }
}
