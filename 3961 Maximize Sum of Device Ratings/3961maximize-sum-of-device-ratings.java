class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;

        long[] r = new long[m];      // minimum
        long[] gain = new long[m];   // max(0, secondMin - min)
        long[] B = new long[m];      // final rating if this device improves itself

        long totalAll = 0;
        long g = Long.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;

            for (int x : units[i]) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }
            }

            if (n == 1) {
                min2 = 0; // removing the only unit leaves the device empty
            }

            r[i] = min1;
            g = Math.min(g, min1);

            gain[i] = Math.max(0L, min2 - min1);
            B[i] = min1 + gain[i];

            totalAll += B[i];
        }

        if (m == 1) {
            return r[0];
        }

        long minD1 = Long.MAX_VALUE, minD2 = Long.MAX_VALUE;
        int idxMinD1 = -1;

        for (int i = 0; i < m; i++) {
            long d = B[i] - g;

            if (d < minD1) {
                minD2 = minD1;
                minD1 = d;
                idxMinD1 = i;
            } else if (d < minD2) {
                minD2 = d;
            }
        }

        long bestPenalty = Long.MAX_VALUE;

        for (int p = 0; p < m; p++) {
            if (r[p] != g) continue;

            long minLossExcludingP =
                    (idxMinD1 != p) ? minD1 : minD2;

            long penalty = Math.min(gain[p], minLossExcludingP);
            bestPenalty = Math.min(bestPenalty, penalty);
        }

        return totalAll - bestPenalty;
    }
}