class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];

        for (int i=0;i<position.length;i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Double.compare(b[0],a[0]));

        int fleets = 0;
        double currentMaxTime = 0.0;

        for (int i=0;i<pairs.length;i++) {
            double pos = pairs[i][0];
            double sp = pairs[i][1];
            double time = (target - pos) / sp;
            if (time > currentMaxTime) {
                fleets++;
                currentMaxTime = time;
            }
        }

        return fleets;
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}